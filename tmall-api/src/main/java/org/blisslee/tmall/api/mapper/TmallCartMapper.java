package org.blisslee.tmall.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.blisslee.tmall.api.entity.model.TmallCart;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;

@Mapper
//@Component
public interface TmallCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallCart record);

    int insertSelective(TmallCart record);

    TmallCart selectByPrimaryKey(Integer id);

    TmallCart selectByProductId(Integer id);

    int updateByPrimaryKeySelective(TmallCart record);

    int updateByPrimaryKey(TmallCart record);

    List<TmallCart> selectAll(HashMap<String, Object> params);

    List<TmallCart> selectCartItem(@Param("ids") List<Integer> ids, @Param("userId") Integer userId);
}