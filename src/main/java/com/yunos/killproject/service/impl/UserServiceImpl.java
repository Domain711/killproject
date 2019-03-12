package com.yunos.killproject.service.impl;

import com.yunos.killproject.dao.UserDOMapper;
import com.yunos.killproject.dao.UserPasswordDOMapper;
import com.yunos.killproject.dataobject.UserDO;
import com.yunos.killproject.dataobject.UserPasswordDO;
import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.error.EmBusinessError;
import com.yunos.killproject.service.UserService;
import com.yunos.killproject.service.model.UserModel;
import com.yunos.killproject.validation.ValidationResult;
import com.yunos.killproject.validation.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Autowired
    private ValidatorImpl validator;


    @Override
    public UserModel getUserById(Integer id) {
        //调用dao层获取数据对象
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if (null == userDO) {
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(id);
        if (null == userPasswordDO) {
            return null;
        }
        return convertFromDataObject(userDO, userPasswordDO);
    }

    @Override
    public UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException {
        //根据手机号查询用户
        UserDO userDO = userDOMapper.selectByTelphone(telphone);
        if (null == userDO) {
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        //校验密码是否匹配
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        UserModel userModel = convertFromDataObject(userDO, userPasswordDO);

        if (!StringUtils.equals(userModel.getPassword(), encrptPassword)) {
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }

        return userModel;
    }

    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if (null == userModel) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //做校验
//        if (StringUtils.isEmpty(userModel.getName()) || StringUtils.isEmpty(userModel.getTelphone())
//                || null == userModel.getAge() || null == userModel.getGender()
//        ) {
//            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
//        }

        //使用validator做校验
        ValidationResult validationResult = validator.validate(userModel);

        if(validationResult.isHasError()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,validationResult.getErrMsg());
        }
        //model->dataobject
        UserDO userDO = convertFromModel(userModel);
        userDOMapper.insertSelective(userDO);
        userModel.setId(userDO.getId());
        UserPasswordDO userPasswordDO = convertPasswordFromModel(userModel);
        userPasswordDOMapper.insertSelective(userPasswordDO);

    }

    //user model 转为userpassword dataobject
    private UserPasswordDO convertPasswordFromModel(UserModel userModel) {
        if (null == userModel) {
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getPassword());
        userPasswordDO.setUserId(userModel.getId());
        return userPasswordDO;
    }

    //user model 转为dataobject
    private UserDO convertFromModel(UserModel userModel) {
        if (null == userModel) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel, userDO);
        return userDO;
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {
        if (null == userDO) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        userModel.setPassword(userPasswordDO.getEncrptPassword());
        return userModel;

    }
}
