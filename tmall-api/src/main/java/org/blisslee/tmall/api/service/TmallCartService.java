package org.blisslee.tmall.api.service;

import org.blisslee.tmall.api.entity.model.TmallCart;

import java.util.HashMap;
import java.util.List;

/**
 * 购物车表(TmallCart)表服务接口
 *
 * @author TL
 * @since 2020-05-03 16:25:58
 */
public interface TmallCartService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmallCart queryById(Integer id);


    List<TmallCart> queryByIds(List<Integer> ids,Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmallCart> queryAllByLimit(int offset, int limit);

    List<TmallCart> getAll(HashMap<String, Object> params);

    /**
     * 新增数据
     *
     * @param tmallCart 实例对象
     * @return 是否成功
     */
    boolean insert(TmallCart tmallCart);

    /**
     * 修改数据
     *
     * @param tmallCart 实例对象
     * @return 是否成功
     */
    boolean update(TmallCart tmallCart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}