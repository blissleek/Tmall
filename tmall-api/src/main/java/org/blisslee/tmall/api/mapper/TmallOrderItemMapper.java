package org.blisslee.tmall.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.blisslee.tmall.api.entity.model.TmallOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallOrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallOrderItem record);

    int insertSelective(TmallOrderItem record);

    TmallOrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallOrderItem record);

    int updateByPrimaryKey(TmallOrderItem record);

    List<TmallOrderItem> selectAll(HashMap<String, Object> params);

    List<TmallOrderItem> selectTimeOutOrderItem(@Param("orderIds") List<Integer> orderIds);
}