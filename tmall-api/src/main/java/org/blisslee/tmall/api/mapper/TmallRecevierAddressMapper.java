package org.blisslee.tmall.api.mapper;

import org.blisslee.tmall.api.entity.model.TmallRecevierAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TmallRecevierAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmallRecevierAddress record);

    int insertSelective(TmallRecevierAddress record);

    TmallRecevierAddress selectByPrimaryKey(Integer id);

    TmallRecevierAddress selectDefaultAddress(Integer userId);

    int updateByPrimaryKeySelective(TmallRecevierAddress record);

    int updateByPrimaryKey(TmallRecevierAddress record);

    List<TmallRecevierAddress> selectAll(HashMap<String, Object> params);

    int countSelectAll(HashMap<String, Object> params);

    int updateDefaultAddress(Integer id);
}