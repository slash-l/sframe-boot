package com.sframe.component.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sframe.component.common.base.exception.BusinessException;
import com.sframe.component.common.util.KeyGenerator;
import com.sframe.component.user.bean.UserBean;
import com.sframe.component.user.bean.UserBeanExample;
import com.sframe.component.user.constant.UserExceptionCode;
import com.sframe.component.user.dao.UserBeanMapper;
import com.sframe.component.user.invo.UserCreateInvo;
import com.sframe.component.user.invo.UserQueryInvo;
import com.sframe.component.user.outvo.UserOutvo;
import com.sframe.component.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    public PageInfo<UserOutvo> getUserListByPage(UserQueryInvo userQueryInvo) {
        log.info("query user list");
        PageHelper.startPage(userQueryInvo.getPageNum(), userQueryInvo.getPageSize());
        //查询条件使用 example 组装
        UserBeanExample example = new UserBeanExample();
        UserBeanExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(userQueryInvo.getLoginName())){
            criteria.andLoginNameLike("%" + userQueryInvo.getLoginName() + "%");
        }
        if(userQueryInvo.getFromAge()!=null && userQueryInvo.getToAge()!=null){
            criteria.andAgeBetween(userQueryInvo.getFromAge(), userQueryInvo.getToAge());
        }
        if(StringUtils.isNotBlank(userQueryInvo.getEmail())){
            criteria.andEmailLike("%" + userQueryInvo.getEmail() + "%");
        }
        if(StringUtils.isNotBlank(userQueryInvo.getMobile())){
            criteria.andMobileLike("%" + userQueryInvo.getMobile() + "%");
        }
        List<UserBean> userBeanList = userBeanMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userBeanList)){
            List<UserOutvo> userOutvoList = userBeanList.stream().map(t -> {
                UserOutvo userOutvo = new UserOutvo();
                BeanUtils.copyProperties(t, userOutvo);
                return userOutvo;
            }).collect(Collectors.toList());
            PageInfo<UserOutvo> userOutvoPageInfo = new PageInfo<>(userOutvoList);
            return userOutvoPageInfo;
        }
        return new PageInfo<UserOutvo>();
    }

    @Override
    public String createUser(UserCreateInvo userCreateInvo) throws BusinessException{
        String userId = KeyGenerator.getUuid();
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userCreateInvo, userBean);
        userBean.setUserId(userId);
        int result = userBeanMapper.insert(userBean);
        if(result < 0){
            throw new BusinessException(UserExceptionCode.CREATE_USER_ERROR.name());
        }
        return userId;
    }
}
