package org.blisslee.tmall.api.mapper;

import org.blisslee.tmall.api.entity.model.TmallCarousel;
import org.blisslee.tmall.api.entity.model.TmallUser;

import java.util.HashMap;
import java.util.List;

public interface TmallCarouselMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallCarousel record);

    int insertSelective(TmallCarousel record);

    TmallCarousel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmallCarousel record);

    int updateByPrimaryKey(TmallCarousel record);

    List<TmallCarousel> selectAll(HashMap<String, Object> params);

    Integer countSelectAll(HashMap<String, Object> params);
}