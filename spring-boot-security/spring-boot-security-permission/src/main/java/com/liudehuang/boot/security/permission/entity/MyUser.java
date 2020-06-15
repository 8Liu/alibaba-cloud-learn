package com.liudehuang.boot.security.permission.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-06
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-06
 * @UpdateRemark:
 * @Version: 1.0
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = 3497935890426858541L;

    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
