package com.liudehuang.sentinel.cluster.embedded.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-03
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-03
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
public class ClusterEmbeddedController {

    @GetMapping("/hello/{name}")
    public String apiHello(@PathVariable String name) throws Exception {
        return "hello,"+name;
    }
}
