package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.cache.RedisService;
import org.blisslee.tmall.api.entity.model.TmallProductSpu;
import org.blisslee.tmall.api.mapper.TmallProductSpuMapper;
import org.blisslee.tmall.api.service.TmallProductSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 4:51 下午
 */
@Service
public class TmallProductSpuServiceImpl implements TmallProductSpuService {
    private final TmallProductSpuMapper tmallProductSpuMapper;
    private final RedisService redisService;

    @Autowired
    public TmallProductSpuServiceImpl(TmallProductSpuMapper tmallProductSpuMapper, RedisService redisService) {
        this.tmallProductSpuMapper = tmallProductSpuMapper;
        this.redisService = redisService;
    }

    @Override
    public TmallProductSpu queryById(Integer id) {
        return tmallProductSpuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallProductSpu> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallProductSpu> getAll(HashMap<String, Object> params) {
        return tmallProductSpuMapper.selectAll(params);
    }

    @Override
    public Integer countGetAll(HashMap<String, Object> params) {
        return tmallProductSpuMapper.countSelectAll(params);
    }

    @Override
    public boolean insert(TmallProductSpu tmallProductSpu) {
        return tmallProductSpuMapper.insertSelective(tmallProductSpu) > 0;
    }

    @Override
    public boolean update(TmallProductSpu tmallProductSpu) {
        return tmallProductSpuMapper.updateByPrimaryKeySelective(tmallProductSpu) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallProductSpuMapper.deleteByPrimaryKey(id) > 0;
    }
}
