package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.SequenceDo;

public interface SequenceDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Fri Mar 15 09:57:09 CST 2019
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Fri Mar 15 09:57:09 CST 2019
     */
    int insert(SequenceDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Fri Mar 15 09:57:09 CST 2019
     */
    int insertSelective(SequenceDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Fri Mar 15 09:57:09 CST 2019
     */
    SequenceDo selectByPrimaryKey(String name);


    /**
     * 根据名称查询序列
     *
     * @param name
     * @return
     */
    SequenceDo selectByName(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Fri Mar 15 09:57:09 CST 2019
     */
    int updateByPrimaryKeySelective(SequenceDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Fri Mar 15 09:57:09 CST 2019
     */
    int updateByPrimaryKey(SequenceDo record);
}