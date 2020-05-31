package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.entity.model.TmallOrderItem;
import org.blisslee.tmall.api.mapper.TmallOrderItemMapper;
import org.blisslee.tmall.api.service.TmallOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 4:49 下午
 */
@Service
public class TmallOrderItemServiceImpl implements TmallOrderItemService {
    private final TmallOrderItemMapper tmallOrderItemMapper;

    @Autowired
    public TmallOrderItemServiceImpl(TmallOrderItemMapper tmallOrderItemMapper) {
        this.tmallOrderItemMapper = tmallOrderItemMapper;
    }

    @Override
    public TmallOrderItem queryById(Integer id) {
        return tmallOrderItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallOrderItem> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallOrderItem> getAll(HashMap<String, Object> params) {
        return tmallOrderItemMapper.selectAll(params);
    }

    @Override
    public boolean insert(TmallOrderItem tmallOrderItem) {
        return tmallOrderItemMapper.insertSelective(tmallOrderItem) > 0;
    }

    @Override
    public boolean update(TmallOrderItem tmallOrderItem) {
        return tmallOrderItemMapper.updateByPrimaryKeySelective(tmallOrderItem) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallOrderItemMapper.deleteByPrimaryKey(id) > 0;
    }
}
