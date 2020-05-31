package org.blisslee.tmall.api.serviceImpl;

import org.blisslee.tmall.api.component.CancelOrderSender;
import org.blisslee.tmall.api.entity.model.TmallCart;
import org.blisslee.tmall.api.entity.model.TmallOrder;
import org.blisslee.tmall.api.entity.model.TmallOrderItem;
import org.blisslee.tmall.api.entity.model.TmallProductSpu;
import org.blisslee.tmall.api.mapper.TmallCartMapper;
import org.blisslee.tmall.api.mapper.TmallOrderItemMapper;
import org.blisslee.tmall.api.mapper.TmallOrderMapper;
import org.blisslee.tmall.api.mapper.TmallProductSpuMapper;
import org.blisslee.tmall.api.service.TmallOrderService;
import org.blisslee.tmall.common.BeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 4:49 下午
 */
@Service
public class TmallOrderServiceImpl implements TmallOrderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Autowired
    private TmallOrderMapper tmallOrderMapper;

    @Autowired
    private TmallCartMapper tmallCartMapper;

    @Autowired
    private TmallOrderItemMapper tmallOrderItemMapper;

    @Autowired
    private TmallProductSpuMapper tmallProductSpuMapper;

    @Override
    public TmallOrder queryById(Integer id) {
        return tmallOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean payOrder(TmallOrder tmallOrder) {
        return tmallOrderMapper.payOrder(tmallOrder) > 0;
    }

    @Override
    public List<TmallOrder> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public List<TmallOrder> getAll(HashMap<String, Object> params) {
        return tmallOrderMapper.selectAll(params);
    }

    @Override
    public Integer countGetAll(HashMap<String, Object> params) {
        return tmallOrderMapper.countSelectAll(params);
    }

    @Override
    public boolean insert(TmallOrder tmallOrder) {
        int minute = 15;
        int insertOrder = tmallOrderMapper.insertSelective(tmallOrder);

        // 获取购物车商品
        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", 0);
        params.put("pageSize", 1000);
        params.put("userId", tmallOrder.getUserId());
        List<TmallCart> tmallCartList = tmallCartMapper.selectAll(params);
        for (TmallCart tmallCart : tmallCartList) {
            // 删减库存
            tmallProductSpuMapper.reduceStock(tmallCart.getProductSpuId(),tmallCart.getProductQuantity());
            tmallCart.setId(null);
            tmallCart.setCreatedAt(null);
            tmallCart.setUpdatedAt(null);
        }
        // 插入商品到订单商品中
        List<TmallOrderItem> tmallOrderItemList = BeanMapper.mapList(tmallCartList, TmallOrderItem.class);
        for (TmallOrderItem tmallOrderItem : tmallOrderItemList) {
            tmallOrderItem.setOrderNo(tmallOrder.getOrderNo());
            tmallOrderItem.setOrderId(tmallOrder.getId());
            tmallOrderItemMapper.insert(tmallOrderItem);
        }
        // 发送延迟消息取消订单
//        cancelOrderSender.sendMessage(tmallOrder.getId(), minute * 60 * 1000);
        return insertOrder > 0;
    }

    @Override
    public boolean update(TmallOrder tmallOrder) {
        return tmallOrderMapper.updateByPrimaryKeySelective(tmallOrder) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return tmallOrderMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public void cancelTimeOutOrder() {
        int minute = 15;

        // 查询超时、未支付的订单
        List<TmallOrder> timeOutOrders = tmallOrderMapper.selectTimeOutOrders(minute);
        if (CollectionUtils.isEmpty(timeOutOrders)) {
            return;
        }
        // 修改订单状态为关闭
        List<Integer> orderIds = new ArrayList<>();
        for (TmallOrder tmallOrder : timeOutOrders) {
            orderIds.add(tmallOrder.getId());
        }
        tmallOrderMapper.updateOrderStatus(orderIds, 4);

        // 解除订单商品库存锁定
        List<TmallOrderItem> timeOutOrderItem = tmallOrderItemMapper.selectTimeOutOrderItem(orderIds);
        List<Integer> ids = new ArrayList<>();
        timeOutOrderItem.forEach(orderItem -> {
            ids.add(orderItem.getProductSpuId());
        });
        List<TmallProductSpu> timeOutOrderProduct = tmallProductSpuMapper.selectTimeOutOrderProduct(ids);
        timeOutOrderItem.forEach(orderItem -> {
            timeOutOrderProduct.forEach(product -> {
                if (orderItem.getProductSpuId().equals(product.getId())) {
                    product.setStock(orderItem.getProductQuantity() + product.getStock());
                    tmallProductSpuMapper.updateByPrimaryKeyWithBLOBs(product);
                }
            });
        });
    }

    @Override
    public void cancelOrder(Integer orderId) {
        List<Integer> orderIds = new ArrayList<>();
        orderIds.add(orderId);
        int cancelOrder = tmallOrderMapper.cancelOrder(orderId);
        if (!(cancelOrder > 0)) {
            return;
        }
        // 解除订单商品库存锁定
        List<TmallOrderItem> timeOutOrderItem = tmallOrderItemMapper.selectTimeOutOrderItem(orderIds);
        List<Integer> ids = new ArrayList<>();
        timeOutOrderItem.forEach(orderItem -> {
            ids.add(orderItem.getProductSpuId());
        });
        List<TmallProductSpu> timeOutOrderProduct = tmallProductSpuMapper.selectTimeOutOrderProduct(ids);
        timeOutOrderItem.forEach(orderItem -> {
            timeOutOrderProduct.forEach(product -> {
                if (orderItem.getProductSpuId().equals(product.getId())) {
                    product.setStock(orderItem.getProductQuantity() + product.getStock());
                    tmallProductSpuMapper.updateByPrimaryKeyWithBLOBs(product);
                }
            });
        });
    }
}
