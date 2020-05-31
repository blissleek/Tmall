package org.blisslee.tmall.api.service;

import org.blisslee.tmall.api.entity.model.TmallCarousel;
import org.blisslee.tmall.api.entity.model.TmallProductBrand;

import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/30 00:33
 */
public interface TmallCarouselService {

    TmallCarousel queryById(Integer id);


    List<TmallCarousel> queryAllByLimit(int offset, int limit);

    List<TmallCarousel> getAll(HashMap<String, Object> params);

    Integer countGetAll(HashMap<String, Object> params);

    boolean insert(TmallCarousel tmallCarousel);

    boolean update(TmallCarousel tmallCarousel);

    boolean deleteById(Integer id);
}
