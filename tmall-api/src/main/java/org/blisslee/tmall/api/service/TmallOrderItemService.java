package org.blisslee.tmall.api.service;

import org.blisslee.tmall.api.entity.model.TmallOrderItem;

import java.util.HashMap;
import java.util.List;

/**
 * 订单中所包含的商品(TmallOrderItem)表服务接口
 *
 * @author TL
 * @since 2020-05-03 16:26:01
 */
public interface TmallOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmallOrderItem queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmallOrderItem> queryAllByLimit(int offset, int limit);

    List<TmallOrderItem> getAll(HashMap<String, Object> params);

    /**
     * 新增数据
     *
     * @param tmallOrderItem 实例对象
     * @return 是否成功
     */
    boolean insert(TmallOrderItem tmallOrderItem);

    /**
     * 修改数据
     *
     * @param tmallOrderItem 实例对象
     * @return 是否成功
     */
    boolean update(TmallOrderItem tmallOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}