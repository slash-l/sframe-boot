package com.sframe.component.user.controller;

import com.github.pagehelper.PageInfo;
import com.sframe.component.common.base.controller.BaseController;
import com.sframe.component.common.base.outvo.ResponseOutvo;
import com.sframe.component.user.constant.UserUrl;
import com.sframe.component.user.invo.UserInvo;
import com.sframe.component.user.outvo.UserOutvo;
import com.sframe.component.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/6/25 2017, 下午10:32
 */
@Slf4j
@RestController
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @GetMapping(value = UserUrl.USER_PAGE)
    public ResponseEntity<ResponseOutvo<PageInfo<UserOutvo>>> getStudentInfo(UserInvo userInvo) {
        PageInfo<UserOutvo> userOutvoPageInfo = this.userService.getUserListByPage(userInvo);
        return ResponseEntity.ok(super.getResponseService().getSuccess(userOutvoPageInfo));
    }

}
