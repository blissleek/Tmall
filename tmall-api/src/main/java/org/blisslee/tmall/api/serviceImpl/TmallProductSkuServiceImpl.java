package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.cache.RedisService;
import org.blisslee.tmall.api.entity.model.TmallProductSku;
import org.blisslee.tmall.api.mapper.TmallProductSkuMapper;
import org.blisslee.tmall.api.service.TmallProductSkuService;
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
public class TmallProductSkuServiceImpl implements TmallProductSkuService {
    private final TmallProductSkuMapper tmallProductSkuMapper;
    private final RedisService redisService;

    @Autowired
    public TmallProductSkuServiceImpl(TmallProductSkuMapper tmallProductSkuMapper, RedisService redisService) {
        this.tmallProductSkuMapper = tmallProductSkuMapper;
        this.redisService = redisService;
    }

    @Override
    public TmallProductSku queryById(Integer id) {
        return tmallProductSkuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallProductSku> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallProductSku> getAll(HashMap<String, Object> params) {
        return tmallProductSkuMapper.selectAll(params);
    }

    @Override
    public boolean insert(TmallProductSku tmallProductSku) {
        return tmallProductSkuMapper.insertSelective(tmallProductSku) > 0;
    }

    @Override
    public boolean update(TmallProductSku tmallProductSku) {
        return tmallProductSkuMapper.updateByPrimaryKeySelective(tmallProductSku) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallProductSkuMapper.deleteByPrimaryKey(id) > 0;
    }
}
