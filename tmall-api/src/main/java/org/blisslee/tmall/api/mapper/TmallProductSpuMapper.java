package org.blisslee.tmall.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.blisslee.tmall.api.entity.model.TmallOrderItem;
import org.blisslee.tmall.api.entity.model.TmallProductSpu;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallProductSpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallProductSpu record);

    int insertSelective(TmallProductSpu record);

    TmallProductSpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallProductSpu record);

    int updateByPrimaryKeyWithBLOBs(TmallProductSpu record);

    int updateByPrimaryKey(TmallProductSpu record);

    List<TmallProductSpu> selectAll(HashMap<String, Object> params);

    int countSelectAll(HashMap<String, Object> params);

    List<TmallProductSpu> selectTimeOutOrderProduct(@Param("ids") List<Integer> ids);

    int updateTimeOutOrderProduct(@Param("ids") List<Integer> ids);
    /*
    * 删减库存
     */
    int reduceStock(@Param("id") Integer id,@Param("stock") Integer stock);
}