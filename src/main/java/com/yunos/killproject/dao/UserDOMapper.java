package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.UserDO;

public interface UserDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    /**
     * 根据手机号查询用户
     *
     * @param telphone
     * @return UserDO
     */
    UserDO selectByTelphone(String telphone);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}