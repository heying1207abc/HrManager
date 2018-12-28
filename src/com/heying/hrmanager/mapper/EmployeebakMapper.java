package com.heying.hrmanager.mapper;

import com.heying.hrmanager.pojo.Employeebak;
import com.heying.hrmanager.pojo.EmployeebakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeebakMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int countByExample(EmployeebakExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int deleteByExample(EmployeebakExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int insert(Employeebak record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int insertSelective(Employeebak record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    List<Employeebak> selectByExample(EmployeebakExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    Employeebak selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int updateByExampleSelective(@Param("record") Employeebak record, @Param("example") EmployeebakExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int updateByExample(@Param("record") Employeebak record, @Param("example") EmployeebakExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int updateByPrimaryKeySelective(Employeebak record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employeebak
     *
     * @mbggenerated Tue Dec 11 09:45:28 CST 2018
     */
    int updateByPrimaryKey(Employeebak record);
}