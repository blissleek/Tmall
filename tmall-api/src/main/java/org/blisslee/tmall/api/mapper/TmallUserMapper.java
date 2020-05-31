package org.blisslee.tmall.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.blisslee.tmall.api.entity.model.TmallUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallUser record);

    int insertSelective(TmallUser record);

    TmallUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallUser record);

    int updateByPrimaryKey(TmallUser record);

    List<TmallUser> selectAll(HashMap<String, Object> params);

    Integer countSelectAll(HashMap<String, Object> params);

    TmallUser login(HashMap<String, Object> params);
}