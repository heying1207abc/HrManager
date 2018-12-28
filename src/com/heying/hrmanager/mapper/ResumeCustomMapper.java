package com.heying.hrmanager.mapper;

import com.heying.hrmanager.pojo.QueryVo;
import com.heying.hrmanager.pojo.Resume;
import com.heying.hrmanager.pojo.ResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeCustomMapper {
    public List<Resume> findAllResumeByPage(QueryVo vo) throws Exception;
}