package org.blisslee.tmall.api.service;

import org.blisslee.tmall.api.entity.model.TmallProductCategory;

import java.util.HashMap;
import java.util.List;

/**
 * 商品分类表(TmallProductCategory)表服务接口
 *
 * @author TL
 * @since 2020-05-03 16:26:01
 */
public interface TmallProductCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmallProductCategory queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmallProductCategory> queryAllByLimit(int offset, int limit);


    List<TmallProductCategory> getAll();

    List<TmallProductCategory> getAllCategory(HashMap<String, Object> params);

    Integer countGetAll(HashMap<String, Object> params);

    /**
     * 新增数据
     *
     * @param tmallProductCategory 实例对象
     * @return 是否成功
     */
    boolean insert(TmallProductCategory tmallProductCategory);

    /**
     * 修改数据
     *
     * @param tmallProductCategory 实例对象
     * @return 是否成功
     */
    boolean update(TmallProductCategory tmallProductCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}