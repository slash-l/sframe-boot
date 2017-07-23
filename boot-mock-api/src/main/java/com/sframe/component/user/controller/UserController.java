package com.sframe.component.user.controller;

import com.github.pagehelper.PageInfo;
import com.sframe.component.common.base.constant.ResponseOutvoCode;
import com.sframe.component.common.base.controller.BaseController;
import com.sframe.component.common.base.exception.BusinessException;
import com.sframe.component.common.base.outvo.ResponseOutvo;
import com.sframe.component.common.util.KeyGenerator;
import com.sframe.component.user.constant.UserUrl;
import com.sframe.component.user.invo.UserCreateInvo;
import com.sframe.component.user.outvo.UserOutvo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/23 2017, 下午10:32
 */
@Api(value=UserUrl.USER_DESC,tags={"User"},description="系统用户",produces= MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RestController
public class UserController extends BaseController{

    @ApiOperation(value="查询系统用户信息",notes="查询系统用户信息",httpMethod="GET",produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value={
            @ApiResponse(code=200, message = "SUCCESS"),
            @ApiResponse(code=400, response = ResponseOutvo.class, message = "参数错误"),
            @ApiResponse(code=500, message = "系统错误")
    })
    @GetMapping(value = UserUrl.USER_PAGE)
    public ResponseEntity<ResponseOutvo<PageInfo<UserOutvo>>> getUserPage(UserCreateInvo userInvo){
        PageInfo<UserOutvo> userOutvoPageInfo = new PageInfo();
        List<UserOutvo> userOutvoList = new ArrayList();
        UserOutvo userOutvo1 = new UserOutvo();
        userOutvo1.setUserId(KeyGenerator.getUuid());
        userOutvo1.setLoginName("张三");
        userOutvo1.setAge(30);
        userOutvo1.setEmail("a@163.com");
        userOutvo1.setMobile("13000000000");
        userOutvoList.add(userOutvo1);

        UserOutvo userOutvo2 = new UserOutvo();
        userOutvo2.setUserId(KeyGenerator.getUuid());
        userOutvo2.setLoginName("李四");
        userOutvo2.setAge(40);
        userOutvo2.setEmail("b@163.com");
        userOutvo2.setMobile("13900000000");
        userOutvoList.add(userOutvo2);

        userOutvoPageInfo.setList(userOutvoList);

        userOutvoPageInfo.setIsFirstPage(true);
        userOutvoPageInfo.setPageSize(10);
        userOutvoPageInfo.setPageNum(1);
        return ResponseEntity.ok(super.getResponseService().getSuccess(userOutvoPageInfo));
    }

    @ApiOperation(value="创建系统用户",notes="创建系统用户",httpMethod="POST",produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name="loginName",required=true,paramType="query",dataType="string",value="用户名"),
            @ApiImplicitParam(name="age",required=true,paramType="query",dataType="Integer",value="年龄"),
            @ApiImplicitParam(name="email",required=true,paramType="query",dataType="string",value="email"),
            @ApiImplicitParam(name="mobile",required=true,paramType="query",dataType="string",value="手机号")
    })
    @ApiResponses(value={
            @ApiResponse(code=200, message = "SUCCESS"),
            @ApiResponse(code=400, response = ResponseOutvo.class, message = "参数错误"),
            @ApiResponse(code=500, message = "系统错误")
    })
    @PostMapping(value = UserUrl.USER_INFO)
    public ResponseEntity<ResponseOutvo<String>> createUser(@Validated @RequestBody UserCreateInvo userInvo, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(super.getResponseService().
                    getError(ResponseOutvoCode.INPUT_PARAM_ERROR.name(), bindingResult.getFieldError().getDefaultMessage()));
        }
        String userId = KeyGenerator.getUuid();
        return ResponseEntity.ok(super.getResponseService().getSuccess(userId));
    }

}
