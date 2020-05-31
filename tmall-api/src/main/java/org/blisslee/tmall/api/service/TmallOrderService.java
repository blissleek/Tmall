package org.blisslee.tmall.api.service;

import org.blisslee.tmall.api.entity.model.TmallOrder;
import org.blisslee.tmall.common.JsonResult;

import java.util.HashMap;
import java.util.List;

/**
 * 订单表(TmallOrder)表服务接口
 *
 * @author TL
 * @since 2020-05-03 16:26:01
 */
public interface TmallOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmallOrder queryById(Integer id);

    boolean payOrder(TmallOrder tmallOrder);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmallOrder> queryAllByLimit(int offset, int limit);

    List<TmallOrder> getAll(HashMap<String, Object> params);

    Integer countGetAll(HashMap<String, Object> params);

    /**
     * 新增数据
     *
     * @param tmallOrder 实例对象
     * @return 是否成功
     */
    boolean insert(TmallOrder tmallOrder);

    /**
     * 修改数据
     *
     * @param tmallOrder 实例对象
     * @return 是否成功
     */
    boolean update(TmallOrder tmallOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    void cancelTimeOutOrder();

    void cancelOrder(Integer orderId);

}