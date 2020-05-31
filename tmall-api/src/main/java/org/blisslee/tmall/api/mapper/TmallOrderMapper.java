package org.blisslee.tmall.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.blisslee.tmall.api.entity.model.TmallOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallOrder record);

    int insertSelective(TmallOrder record);

    TmallOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallOrder record);

    int updateByPrimaryKey(TmallOrder record);

    List<TmallOrder> selectAll(HashMap<String, Object> params);

    int countSelectAll(HashMap<String, Object> params);

    int payOrder(TmallOrder record);


    /**
     * 获取超时订单
     */
    List<TmallOrder> selectTimeOutOrders(@Param("minute") Integer minute);

    int cancelOrder(@Param("orderId") Integer orderId);

    /**
     * 批量修改订单状态
     */
    int updateOrderStatus(@Param("orderIds") List<Integer> orderIds,@Param("status") Integer status);
}