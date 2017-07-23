package com.sframe.component.user.service;

import com.github.pagehelper.PageInfo;
import com.sframe.component.common.base.exception.BusinessException;
import com.sframe.component.user.invo.UserCreateInvo;
import com.sframe.component.user.invo.UserQueryInvo;
import com.sframe.component.user.outvo.UserOutvo;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/6/25 2017, 下午10:23
 */
public interface UserService {

    /**
     * 根据条件查询用户列表数据
     * @param userQueryInvo
     * @return
     */
    PageInfo<UserOutvo> getUserListByPage(UserQueryInvo userQueryInvo);

    /**
     * 创建用户
     * @param userInvo
     * @return  创建用户的主键
     */
    String createUser(UserCreateInvo userInvo) throws BusinessException;


}
