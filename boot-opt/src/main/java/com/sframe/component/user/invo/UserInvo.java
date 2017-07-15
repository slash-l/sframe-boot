package com.sframe.component.user.invo;

import com.sframe.component.common.base.invo.PageInvo;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/3 2017, 下午10:16
 */
@Data
public class UserInvo extends PageInvo{

    private String userId;

    @NotBlank(message = "${user.loginName.notBlank}")
    @Length(min = 5, max = 20)
    private String loginName;

    @Range(min = 1, max = 100)
    private Integer age;

    @Pattern(regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}", message="邮件格式错误")
    private String email;

    @Digits(integer = 11, fraction = 0)
    private String mobile;

}
