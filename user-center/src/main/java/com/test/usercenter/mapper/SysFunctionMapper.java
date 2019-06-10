package com.test.usercenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.usercenter.entity.SysFunction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysFunctionMapper extends BaseMapper<SysFunction> {
    int insertSelective(SysFunction record);
}