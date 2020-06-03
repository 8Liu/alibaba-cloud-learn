package com.liudehuang.sentinel.restful.config;

import com.alibaba.csp.sentinel.*;
import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.adapter.servlet.config.WebServletConfig;
import com.alibaba.csp.sentinel.adapter.servlet.util.FilterUtil;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-03
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-03
 * @UpdateRemark:
 * @Version: 1.0
 */
@Slf4j
public class SentinelFilter implements Filter {

    /**
     * Specify whether the URL resource name should contain the HTTP method prefix (e.g. {@code POST:}).
     */
    public static final String HTTP_METHOD_SPECIFY = "HTTP_METHOD_SPECIFY";
    /**
     * If enabled, use the URL path as the context name, or else use the default
     * {@link WebServletConfig#WEB_SERVLET_CONTEXT_NAME}. Please pay attention to the number of context (EntranceNode),
     * which may affect the memory footprint.
     *
     * @since 1.7.0
     */
    public static final String WEB_CONTEXT_UNIFY = "WEB_CONTEXT_UNIFY";

    private final static String COLON = ":";

    private final static String ROOT_PATH = "/";

    private boolean httpMethodSpecify = false;
    private boolean webContextUnify = true;

    @Override
    public void init(FilterConfig filterConfig) {
        httpMethodSpecify = Boolean.parseBoolean(filterConfig.getInitParameter(HTTP_METHOD_SPECIFY));
        if (filterConfig.getInitParameter(WEB_CONTEXT_UNIFY) != null) {
            webContextUnify = Boolean.parseBoolean(filterConfig.getInitParameter(WEB_CONTEXT_UNIFY));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest sRequest = (HttpServletRequest) request;
        String merchantId = sRequest.getHeader("Authorization");
        if(StringUtils.isEmpty(merchantId)){
            throw new RuntimeException("商户号不能为空");
        }
        Entry urlEntry = null;

        try {
            String target = FilterUtil.filterTarget(sRequest);
            if (target.startsWith(ROOT_PATH)) {
                target = target.substring(1);
            }
            target = merchantId+"_"+target;
            // Clean and unify the URL.
            // For REST APIs, you have to clean the URL (e.g. `/foo/1` and `/foo/2` -> `/foo/:id`), or
            // the amount of context and resources will exceed the threshold.
            UrlCleaner urlCleaner = WebCallbackManager.getUrlCleaner();
            if (urlCleaner != null) {
                target = urlCleaner.clean(target);
            }

            // If you intend to exclude some URLs, you can convert the URLs to the empty string ""
            // in the UrlCleaner implementation.
            if (!StringUtil.isEmpty(target)) {
                // Parse the request origin using registered origin parser.
                String origin = parseOrigin(sRequest);
                String contextName = webContextUnify ? WebServletConfig.WEB_SERVLET_CONTEXT_NAME : target;
                ContextUtil.enter(contextName, origin);

                if (httpMethodSpecify) {
                    // Add HTTP method prefix if necessary.
                    String pathWithHttpMethod = sRequest.getMethod().toUpperCase() + COLON + target;
                    urlEntry = SphU.entry(pathWithHttpMethod, ResourceTypeConstants.COMMON_WEB, EntryType.IN);
                } else {
                    urlEntry = SphU.entry(target, ResourceTypeConstants.COMMON_WEB, EntryType.IN);
                }
            }
            chain.doFilter(request, response);
        } catch (BlockException e) {
            HttpServletResponse sResponse = (HttpServletResponse) response;
            // Return the block page, or redirect to another URL.
            WebCallbackManager.getUrlBlockHandler().blocked(sRequest, sResponse, e);
        } catch (IOException | ServletException | RuntimeException e2) {
            Tracer.traceEntry(e2, urlEntry);
            throw e2;
        } finally {
            if (urlEntry != null) {
                urlEntry.exit();
            }
            ContextUtil.exit();
        }
    }

    private String parseOrigin(HttpServletRequest request) {
        RequestOriginParser originParser = WebCallbackManager.getRequestOriginParser();
        String origin = EMPTY_ORIGIN;
        if (originParser != null) {
            origin = originParser.parseOrigin(request);
            if (StringUtil.isEmpty(origin)) {
                return EMPTY_ORIGIN;
            }
        }
        return origin;
    }

    @Override
    public void destroy() {

    }

    private static final String EMPTY_ORIGIN = "";
}
