package com.sframe.component.user.controller;

import com.github.pagehelper.PageInfo;
import com.sframe.component.common.base.constant.ResponseOutvoCode;
import com.sframe.component.common.base.controller.BaseController;
import com.sframe.component.common.base.outvo.ResponseOutvo;
import com.sframe.component.user.constant.UserUrl;
import com.sframe.component.user.invo.UserInvo;
import com.sframe.component.user.outvo.UserOutvo;
import com.sframe.component.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseOutvo<PageInfo<UserOutvo>>> getUserPage(UserInvo userInvo){
        PageInfo<UserOutvo> userOutvoPageInfo = this.userService.getUserListByPage(userInvo);
        return ResponseEntity.ok(super.getResponseService().getSuccess(userOutvoPageInfo));
    }

    @PostMapping(value = UserUrl.USER_INFO)
    public ResponseEntity<ResponseOutvo<String>> createUser(@Validated @RequestBody UserInvo userInvo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(super.getResponseService().
                    getError(ResponseOutvoCode.INPUT_PARAM_ERROR.name(), bindingResult.getFieldError().getDefaultMessage()));
        }
        String userId = userService.createUser(userInvo);
        return ResponseEntity.ok(super.getResponseService().getSuccess(userId));
    }

}
