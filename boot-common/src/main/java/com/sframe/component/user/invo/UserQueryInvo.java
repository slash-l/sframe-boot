package com.sframe.component.user.invo;

import com.sframe.component.common.base.invo.PageInvo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/24 2017, 上午12:03
 */
@ApiModel(value = "查询系统用户的请求入参")
@Data
public class UserQueryInvo extends PageInvo {

    /** 用户登录名 */
    private String loginName;

    /** 用户查询开始年龄 */
    @Range(min = 1, max = 100)
    private Integer fromAge;

    /** 用户查询结束年龄 */
    @Range(min = 1, max = 100)
    private Integer toAge;

    /** 用户email */
    private String email;

    /** 用户手机号 */
    private String mobile;

}
