package org.blisslee.tmall.api.mapper;

import org.blisslee.tmall.api.entity.model.TmallProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallProductSkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallProductSku record);

    int insertSelective(TmallProductSku record);

    TmallProductSku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallProductSku record);

    int updateByPrimaryKey(TmallProductSku record);

    List<TmallProductSku> selectAll(HashMap<String, Object> params);
}