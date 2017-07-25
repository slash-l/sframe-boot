package com.sframe.component.user.outvo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/3 2017, 下午10:18
 */
@ApiModel(value = "查询系统用户返回参数")
@Data
public class UserOutvo {

    /** 用户ID */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /** 用户登录名 */
    @ApiModelProperty(value = "用户登录名")
    private String loginName;

    /** 年龄 */
    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    /** email */
    @ApiModelProperty(value = "用户email")
    private String email;

    /** 手机号 */
    @ApiModelProperty(value = "用户手机号")
    private String mobile;

}
