package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.entity.model.TmallUser;
import org.blisslee.tmall.api.mapper.TmallUserMapper;
import org.blisslee.tmall.api.service.TmallUserService;
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
public class TmallUserServiceImpl implements TmallUserService {
    private final TmallUserMapper tmallUserMapper;

    @Autowired
    public TmallUserServiceImpl(TmallUserMapper tmallUserMapper) {
        this.tmallUserMapper = tmallUserMapper;
    }

    @Override
    public TmallUser queryById(Integer id) {
        return tmallUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallUser> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallUser> getAll(HashMap<String, Object> params) {
        return tmallUserMapper.selectAll(params);
    }

    @Override
    public Integer countGetAll(HashMap<String, Object> params) {
        return tmallUserMapper.countSelectAll(params);
    }

    @Override
    public boolean insert(TmallUser tmallUser) {
        return tmallUserMapper.insertSelective(tmallUser) > 0;
    }

    @Override
    public boolean update(TmallUser tmallUser) {
        return tmallUserMapper.updateByPrimaryKeySelective(tmallUser) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallUserMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public TmallUser login(HashMap<String, Object> params) {
        return tmallUserMapper.login(params);
    }
}
