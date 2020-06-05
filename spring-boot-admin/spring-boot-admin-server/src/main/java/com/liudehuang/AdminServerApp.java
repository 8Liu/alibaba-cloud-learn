package com.liudehuang;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-04
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-04
 * @UpdateRemark:
 * @Version: 1.0
 */
@SpringBootApplication
@EnableAdminServer
public class AdminServerApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApp.class,args);
    }
}
