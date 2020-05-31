package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.entity.model.TmallProductCategory;
import org.blisslee.tmall.api.mapper.TmallProductCategoryMapper;
import org.blisslee.tmall.api.service.TmallProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 4:50 下午
 */
@Service
public class TmallProductCategoryServiceImpl implements TmallProductCategoryService {
    private final TmallProductCategoryMapper tmallProductCategoryMapper;

    @Autowired
    public TmallProductCategoryServiceImpl(TmallProductCategoryMapper tmallProductCategoryMapper) {
        this.tmallProductCategoryMapper = tmallProductCategoryMapper;
    }

    @Override
    public TmallProductCategory queryById(Integer id) {
        return tmallProductCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallProductCategory> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallProductCategory> getAll() {
        return tmallProductCategoryMapper.selectAll();
    }

    @Override
    public List<TmallProductCategory> getAllCategory(HashMap<String, Object> params) {
        return tmallProductCategoryMapper.selectAllCategory(params);
    }

    @Override
    public Integer countGetAll(HashMap<String, Object> params) {
        return tmallProductCategoryMapper.countSelectAll(params);
    }


    @Override
    public boolean insert(TmallProductCategory tmallProductCategory) {
        return tmallProductCategoryMapper.insertSelective(tmallProductCategory) > 0;
    }

    @Override
    public boolean update(TmallProductCategory tmallProductCategory) {
        return tmallProductCategoryMapper.updateByPrimaryKeySelective(tmallProductCategory) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallProductCategoryMapper.deleteByPrimaryKey(id) > 0;
    }
}
