package com.yunos.killproject.service;

import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.service.model.UserModel;

public interface UserService {

    //根据用户ID获取对象
    UserModel getUserById(Integer id);

    //校验用户登录是否合法
    UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException;

    //用户注册
    void register(UserModel userModel) throws BusinessException;
}
