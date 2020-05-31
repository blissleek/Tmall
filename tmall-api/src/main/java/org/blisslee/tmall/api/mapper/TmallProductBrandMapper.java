package org.blisslee.tmall.api.mapper;

import org.blisslee.tmall.api.entity.model.TmallProductBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallProductBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallProductBrand record);

    int insertSelective(TmallProductBrand record);

    TmallProductBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallProductBrand record);

    int updateByPrimaryKey(TmallProductBrand record);

    List<TmallProductBrand> selectAll(HashMap<String, Object> params);

    int countSelectAll(HashMap<String, Object> params);
}