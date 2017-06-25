package com.sframe.component.user.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sframe.component.user.bean.UserBean;
import com.sframe.component.user.bean.UserBeanExample;
import com.sframe.component.user.dao.UserBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/6/25 2017, 下午10:32
 */
@Slf4j
@RestController
@RequestMapping(value="/v1/user")
public class UserController {

    @Resource
    private UserBeanMapper userBeanMapper;

    @GetMapping(value = "/user")
    public String getStudentInfo(Integer pageNum, Integer pageSize) {
        log.info("query user list");
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        UserBeanExample example = new UserBeanExample();
        List<UserBean> list = userBeanMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        Page page = (Page) list;
        return "PageInfo: " + JSON.toJSONString(pageInfo) + ", Page: " + JSON.toJSONString(page);
    }
}
