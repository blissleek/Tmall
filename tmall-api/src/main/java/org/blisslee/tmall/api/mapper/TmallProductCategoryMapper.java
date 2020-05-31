package org.blisslee.tmall.api.mapper;

import org.blisslee.tmall.api.entity.model.TmallProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallProductCategory record);

    int insertSelective(TmallProductCategory record);

    TmallProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallProductCategory record);

    int updateByPrimaryKey(TmallProductCategory record);

    List<TmallProductCategory> selectAll();

    List<TmallProductCategory> selectAllCategory(HashMap<String, Object> params);

    int countSelectAll(HashMap<String, Object> params);
}