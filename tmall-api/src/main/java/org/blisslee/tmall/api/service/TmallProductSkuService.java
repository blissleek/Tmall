package org.blisslee.tmall.api.service;

import org.blisslee.tmall.api.entity.model.TmallProductSku;

import java.util.HashMap;
import java.util.List;

/**
 * 商品SKU(Stock Keeping Unit)表(TmallProductSku)表服务接口
 *
 * @author TL
 * @since 2020-05-03 16:26:01
 */
public interface TmallProductSkuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmallProductSku queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmallProductSku> queryAllByLimit(int offset, int limit);

    List<TmallProductSku> getAll(HashMap<String, Object> params);

    /**
     * 新增数据
     *
     * @param tmallProductSku 实例对象
     * @return 是否成功
     */
    boolean insert(TmallProductSku tmallProductSku);

    /**
     * 修改数据
     *
     * @param tmallProductSku 实例对象
     * @return 是否成功
     */
    boolean update(TmallProductSku tmallProductSku);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}