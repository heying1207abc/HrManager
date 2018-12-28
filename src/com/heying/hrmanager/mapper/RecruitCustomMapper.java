package com.heying.hrmanager.mapper;

import com.heying.hrmanager.pojo.QueryVo;
import com.heying.hrmanager.pojo.Recruit;
import com.heying.hrmanager.pojo.RecruitCustom;
import com.heying.hrmanager.pojo.RecruitExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitCustomMapper {
   public List<RecruitCustom> findAllRecruitCustom(QueryVo vo) throws Exception;
   
   public List<RecruitCustom> findAllRecruitCustomByPage(QueryVo vo) throws Exception;
   
   public List<RecruitCustom> findRecruitAndResumeList(QueryVo vo)throws Exception;

}