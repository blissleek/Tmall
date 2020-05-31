package org.blisslee.tmall.api.service;

import org.blisslee.tmall.api.entity.model.TmallUser;

import java.util.HashMap;
import java.util.List;

/**
 * 用户表(TmallUser)表服务接口
 *
 * @author TL
 * @since 2020-05-03 16:26:01
 */
public interface TmallUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmallUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmallUser> queryAllByLimit(int offset, int limit);


    List<TmallUser> getAll(HashMap<String, Object> params);

    Integer  countGetAll(HashMap<String, Object> params);

    /**
     * 新增数据
     *
     * @param tmallUser 实例对象
     * @return 是否成功
     */
    boolean insert(TmallUser tmallUser);

    /**
     * 修改数据
     *
     * @param tmallUser 实例对象
     * @return 是否成功
     */
    boolean update(TmallUser tmallUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    TmallUser login(HashMap<String, Object> params);

}