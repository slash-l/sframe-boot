package com.sframe.component.user.controller;

import com.github.pagehelper.PageInfo;
import com.sframe.component.common.base.constant.ResponseOutvoCode;
import com.sframe.component.common.base.controller.BaseController;
import com.sframe.component.common.base.exception.BusinessException;
import com.sframe.component.common.base.outvo.ResponseOutvo;
import com.sframe.component.common.util.KeyGenerator;
import com.sframe.component.user.constant.UserUrl;
import com.sframe.component.user.invo.UserCreateInvo;
import com.sframe.component.user.invo.UserQueryInvo;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name="loginName",paramType="query",dataType="string",value="用户登录名"),
            @ApiImplicitParam(name="fromAge",paramType="query",dataType="int",value="用户查询开始年龄"),
            @ApiImplicitParam(name="toAge",paramType="query",dataType="int",value="用户查询结束年龄"),
            @ApiImplicitParam(name="email",paramType="query",dataType="string",value="用户email"),
            @ApiImplicitParam(name="mobile",paramType="query",dataType="int",value="用户手机号"),
            @ApiImplicitParam(name="pageSize",paramType="query",dataType="int",value="每页显示记录数"),
            @ApiImplicitParam(name="pageNum",paramType="query",dataType="int",value="查询页码")
    })
    @GetMapping(value = UserUrl.USER_PAGE)
    public ResponseEntity<ResponseOutvo<PageInfo<UserOutvo>>> getUserPage(@Validated UserQueryInvo userQueryInvo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(super.getResponseService().
                    getError(ResponseOutvoCode.INPUT_PARAM_ERROR.name(), bindingResult.getFieldError().getDefaultMessage()));
        }
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
    @PostMapping(value = UserUrl.USER_INFO)
    public ResponseEntity<ResponseOutvo<String>> createUser(@Validated @RequestBody UserCreateInvo userCreateInvo, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(super.getResponseService().
                    getError(ResponseOutvoCode.INPUT_PARAM_ERROR.name(), bindingResult.getFieldError().getDefaultMessage()));
        }
        String userId = KeyGenerator.getUuid();
        return ResponseEntity.ok(super.getResponseService().getSuccess(userId));
    }

}
