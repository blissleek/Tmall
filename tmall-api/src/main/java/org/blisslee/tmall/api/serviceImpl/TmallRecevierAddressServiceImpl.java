package org.blisslee.tmall.api.serviceImpl;

import org.apache.ibatis.jdbc.Null;
import org.blisslee.tmall.api.entity.model.TmallRecevierAddress;
import org.blisslee.tmall.api.mapper.TmallRecevierAddressMapper;
import org.blisslee.tmall.api.service.TmallRecevierAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 4:51 下午
 */
@Service
public class TmallRecevierAddressServiceImpl implements TmallRecevierAddressService {
    private final TmallRecevierAddressMapper tmallRecevierAddressMapper;

    @Autowired
    public TmallRecevierAddressServiceImpl(TmallRecevierAddressMapper tmallRecevierAddressMapper) {
        this.tmallRecevierAddressMapper = tmallRecevierAddressMapper;
    }

    @Override
    public TmallRecevierAddress queryById(Integer id) {
        return tmallRecevierAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallRecevierAddress> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallRecevierAddress> getAll(HashMap<String, Object> params) {
        return tmallRecevierAddressMapper.selectAll(params);
    }

    @Override
    public Integer countGetAll(HashMap<String, Object> params) {
        return tmallRecevierAddressMapper.countSelectAll(params);
    }

    @Transactional
    @Override
    public boolean insert(TmallRecevierAddress tmallRecevierAddress) {
        int success = tmallRecevierAddressMapper.insertSelective(tmallRecevierAddress);
        if (tmallRecevierAddress.getIsDefault() == 1) {
            success = tmallRecevierAddressMapper.updateDefaultAddress(tmallRecevierAddress.getId());
        }
        return success > 0;
    }


    @Override
    @Transactional
    public boolean update(TmallRecevierAddress tmallRecevierAddress) {
        int success = tmallRecevierAddressMapper.updateByPrimaryKeySelective(tmallRecevierAddress);
        if (tmallRecevierAddress.getIsDefault() == 1) {
            success = tmallRecevierAddressMapper.updateDefaultAddress(tmallRecevierAddress.getId());
        }
        return success > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallRecevierAddressMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public TmallRecevierAddress selectDefaultAddress(Integer userId) {
        TmallRecevierAddress address = tmallRecevierAddressMapper.selectDefaultAddress(userId);
        if (address !=  null) {
            return address;
        } else {
            HashMap<String, Object> params = new HashMap<>();
            params.put("userId", userId);
            params.put("offset", 0);
            params.put("pageSize", 1);
            List<TmallRecevierAddress> tmallRecevierAddressList = tmallRecevierAddressMapper.selectAll(params);
            return tmallRecevierAddressList.size() != 0 ? tmallRecevierAddressList.get(0) : null;
        }
    }
}
