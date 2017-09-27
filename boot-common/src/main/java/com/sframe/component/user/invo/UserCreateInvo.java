package com.sframe.component.user.invo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/3 2017, 下午10:16
 */
@ApiModel(value = "创建系统用户的请求入参")
@Data
public class UserCreateInvo implements Serializable {

    /** 用户登录名 */
    @ApiModelProperty(value = "用户登录名", required = true)
    @NotBlank(message = "${user.loginName.notBlank}")
    @Length(min = 5, max = 20)
    private String loginName;

    /** 用户年龄 */
    @ApiModelProperty(value = "用户年龄")
    @Range(min = 1, max = 100)
    private Integer age;

    /** 用户email */
    @ApiModelProperty(value = "用户email")
    @Pattern(regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}", message="邮件格式错误")
    private String email;

    /** 用户手机号 */
    @ApiModelProperty(value = "用户手机号")
    @Digits(integer = 11, fraction = 0)
    private String mobile;

}
