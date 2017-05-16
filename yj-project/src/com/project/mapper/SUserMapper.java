package com.project.mapper;

import com.project.po.SUser;
import com.project.po.SUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SUserMapper {

    long countByExample(SUserExample example);


    int deleteByExample(SUserExample example);


    int deleteByPrimaryKey(Integer userId);


    int insert(SUser record);


    int insertSelective(SUser record);


    List<SUser> selectByExample(SUserExample example);


    SUser selectByPrimaryKey(Integer userId);


    int updateByExampleSelective(@Param("record") SUser record, @Param("example") SUserExample example);


    int updateByExample(@Param("record") SUser record, @Param("example") SUserExample example);


    int updateByPrimaryKeySelective(SUser record);


    int updateByPrimaryKey(SUser record);
}