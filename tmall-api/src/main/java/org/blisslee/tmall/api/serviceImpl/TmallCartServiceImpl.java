package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.entity.model.TmallCart;
import org.blisslee.tmall.api.entity.model.TmallProductBrand;
import org.blisslee.tmall.api.entity.model.TmallProductSpu;
import org.blisslee.tmall.api.mapper.TmallCartMapper;
import org.blisslee.tmall.api.mapper.TmallProductBrandMapper;
import org.blisslee.tmall.api.mapper.TmallProductSpuMapper;
import org.blisslee.tmall.api.service.TmallCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 4:03 下午
 */
@Service
public class TmallCartServiceImpl implements TmallCartService {

    private final TmallCartMapper tmallCartMapper;

    private final TmallProductSpuMapper tmallProductSpuMapper;

    private final TmallProductBrandMapper tmallProductBrandMapper;

    @Autowired
    public TmallCartServiceImpl(TmallCartMapper tmallCartMapper, TmallProductSpuMapper tmallProductSpuMapper, TmallProductBrandMapper tmallProductBrandMapper) {
        this.tmallCartMapper = tmallCartMapper;
        this.tmallProductSpuMapper = tmallProductSpuMapper;
        this.tmallProductBrandMapper = tmallProductBrandMapper;
    }

    @Override
    public TmallCart queryById(Integer id) {
        return tmallCartMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TmallCart> queryByIds(List<Integer> ids, Integer userId) {
        return tmallCartMapper.selectCartItem(ids, userId);
    }

    @Override
    public List<TmallCart> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallCart> getAll(HashMap<String, Object> params) {
        return tmallCartMapper.selectAll(params);
    }

    @Transactional
    @Override
    public boolean insert(TmallCart tmallCart) {
        TmallCart dbCart = tmallCartMapper.selectByProductId(tmallCart.getProductSpuId());
        TmallProductSpu productSpu = tmallProductSpuMapper.selectByPrimaryKey(tmallCart.getProductSpuId());

        int success = 0;
        if (dbCart != null && dbCart.getUserId().equals(tmallCart.getUserId())) {
            // 修改购物车商品信息
            dbCart.setProductQuantity(dbCart.getProductQuantity() + tmallCart.getProductQuantity());
            BigDecimal productQuantity = new BigDecimal(dbCart.getProductQuantity().toString());
            dbCart.setProductAmount(productQuantity.multiply(dbCart.getProductPrice()));
            // 更新购物车数据库
            success = tmallCartMapper.updateByPrimaryKeySelective(dbCart);
        } else {
            // 设置购物车商品属性
            tmallCart.setProductName(productSpu.getTitle() + " " + productSpu.getSubTitle());
            TmallProductBrand tmallProductBrand = tmallProductBrandMapper.selectByPrimaryKey(productSpu.getProductBrandId());
            tmallCart.setProductBrand(tmallProductBrand == null ? "": tmallProductBrand.getName());
            tmallCart.setProductImage(productSpu.getMainImage());
            tmallCart.setProductPrice(productSpu.getPrice());
            BigDecimal productQuantity = new BigDecimal(tmallCart.getProductQuantity().toString());
            tmallCart.setProductAmount(productQuantity.multiply(tmallCart.getProductPrice()));
            // 插入购物车商品到数据库
            success = tmallCartMapper.insert(tmallCart);
        }

        return success > 0;
    }

    @Override
    public boolean update(TmallCart tmallCart) {
        int success = 0;
        if (tmallCart.getProductQuantity() == 0) {
            TmallCart dbCart = tmallCartMapper.selectByPrimaryKey(tmallCart.getId());
            success = tmallCartMapper.deleteByPrimaryKey(dbCart.getId());
        } else {
            TmallCart dbCart = tmallCartMapper.selectByPrimaryKey(tmallCart.getId());
            BigDecimal productQuantity = new BigDecimal(tmallCart.getProductQuantity().toString());
            tmallCart.setProductAmount(dbCart.getProductPrice().multiply(productQuantity));
            success = tmallCartMapper.updateByPrimaryKeySelective(tmallCart);
        }
        return success > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallCartMapper.deleteByPrimaryKey(id) > 0;
    }
}
