package com.sframe.component.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sframe.component.user.bean.UserBean;
import com.sframe.component.user.bean.UserBeanExample;
import com.sframe.component.user.dao.UserBeanMapper;
import com.sframe.component.user.invo.UserInvo;
import com.sframe.component.user.outvo.UserOutvo;
import com.sframe.component.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/6/25 2017, 下午10:24
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserBeanMapper userBeanMapper;

    @Override
    public PageInfo<UserOutvo> getUserListByPage(UserInvo userInvo) {
        log.info("query user list");
        PageHelper.startPage(userInvo.getPageNum(), userInvo.getPageSize());
        //查询条件使用 example 组装
        UserBeanExample example = new UserBeanExample();
        //...
        List<UserBean> userBeanList = userBeanMapper.selectByExample(example);
        List<UserOutvo> userOutvoList = userBeanList.stream().map(t -> {
            UserOutvo userOutvo = new UserOutvo();
            BeanUtils.copyProperties(t, userOutvo);
            return userOutvo;
        }).collect(Collectors.toList());
        PageInfo<UserOutvo> userOutvoPageInfo = new PageInfo<>(userOutvoList);
        return userOutvoPageInfo;
    }
}
