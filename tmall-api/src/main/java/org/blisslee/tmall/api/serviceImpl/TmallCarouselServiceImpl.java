package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.entity.model.TmallCarousel;
import org.blisslee.tmall.api.mapper.TmallCarouselMapper;
import org.blisslee.tmall.api.service.TmallCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/30 00:33
 */
@Service
public class TmallCarouselServiceImpl implements TmallCarouselService {
    private final TmallCarouselMapper tmallCarouselMapper;

    @Autowired
    public TmallCarouselServiceImpl(TmallCarouselMapper tmallCarouselMapper) {
        this.tmallCarouselMapper = tmallCarouselMapper;
    }

    @Override
    public TmallCarousel queryById(Integer id) {
        return tmallCarouselMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<TmallCarousel> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallCarousel> getAll(HashMap<String, Object> params) {
        return tmallCarouselMapper.selectAll(params);
    }

    @Override
    public Integer countGetAll(HashMap<String, Object> params) {
        return tmallCarouselMapper.countSelectAll(params);
    }

    @Override
    public boolean insert(TmallCarousel tmallCarousel) {
        return tmallCarouselMapper.insert(tmallCarousel) > 0;
    }

    @Override
    public boolean update(TmallCarousel tmallCarousel) {
        return tmallCarouselMapper.updateByPrimaryKeySelective(tmallCarousel) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallCarouselMapper.deleteByPrimaryKey(id) > 0;
    }
}
