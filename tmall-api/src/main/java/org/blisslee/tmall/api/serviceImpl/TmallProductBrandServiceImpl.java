package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.entity.model.TmallProductBrand;
import org.blisslee.tmall.api.mapper.TmallProductBrandMapper;
import org.blisslee.tmall.api.service.TmallProductBrandService;
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
public class TmallProductBrandServiceImpl implements TmallProductBrandService {
    private final TmallProductBrandMapper tmallProductBrandMapper;

    @Autowired
    public TmallProductBrandServiceImpl(TmallProductBrandMapper tmallProductBrandMapper) {
        this.tmallProductBrandMapper = tmallProductBrandMapper;
    }

    @Override
    public TmallProductBrand queryById(Integer id) {
        return tmallProductBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallProductBrand> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallProductBrand> getAll(HashMap<String, Object> params) {
        return tmallProductBrandMapper.selectAll(params);
    }

    @Override
    public Integer countGetAll(HashMap<String, Object> params) {
        return tmallProductBrandMapper.countSelectAll(params);
    }

    @Override
    public boolean insert(TmallProductBrand tmallProductBrand) {
        return tmallProductBrandMapper.insertSelective(tmallProductBrand) > 0;
    }

    @Override
    public boolean update(TmallProductBrand tmallProductBrand) {
        return tmallProductBrandMapper.updateByPrimaryKeySelective(tmallProductBrand) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallProductBrandMapper.deleteByPrimaryKey(id) > 0;
    }
}
