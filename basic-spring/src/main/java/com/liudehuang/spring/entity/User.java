package com.liudehuang.spring.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {

    private String userName;

    private Integer age;

}
