package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.OrderInfoDo;

public interface OrderDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    int insert(OrderInfoDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    int insertSelective(OrderInfoDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    OrderInfoDo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    int updateByPrimaryKeySelective(OrderInfoDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    int updateByPrimaryKey(OrderInfoDo record);
}