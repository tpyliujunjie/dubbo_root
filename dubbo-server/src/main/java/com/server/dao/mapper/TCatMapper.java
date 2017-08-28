package com.server.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.common.dto.TCat;
@Mapper
public interface TCatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCat record);

    int insertSelective(TCat record);

    TCat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCat record);

    int updateByPrimaryKeyWithBLOBs(TCat record);

    int updateByPrimaryKey(TCat record);
}