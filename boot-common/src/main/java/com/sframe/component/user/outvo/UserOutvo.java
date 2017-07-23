package com.sframe.component.user.outvo;

import lombok.Data;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/3 2017, 下午10:18
 */
@Data
public class UserOutvo {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * email
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

}
