package com.liudehuang.boot.security.jwttoken.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @PreAuthorize("hasAnyRole('ROLE_admin','ROLE_test')")
    @GetMapping("/queryItemByItemNo")
    public String queryItemByItemNo(){
        return "queryItemByItemNo";
    }

    @PreAuthorize("hasAnyRole('ROLE_admin')")
    @GetMapping("/saveItem")
    public String saveItem(){
        return "saveItem";
    }

    @PreAuthorize("hasAnyRole('ROLE_test')")
    @GetMapping("/updateItem")
    public String updateItem(){
        return "updateItem";
    }
}
