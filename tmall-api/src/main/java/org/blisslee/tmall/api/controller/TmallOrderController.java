package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallOrder.*;
import org.blisslee.tmall.api.entity.model.TmallOrder;
import org.blisslee.tmall.api.service.TmallCartService;
import org.blisslee.tmall.api.service.TmallOrderItemService;
import org.blisslee.tmall.api.service.TmallOrderService;
import org.blisslee.tmall.common.BeanMapper;
import org.blisslee.tmall.common.JsonResult;
import org.blisslee.tmall.common.Message;
import org.blisslee.tmall.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 3:52 下午
 */
@Api(tags = "order API",value = "TmallOrderController")
@RestController
@CrossOrigin
@RequestMapping("/order")
public class TmallOrderController {

    private final TmallOrderService tmallOrderService;

    private final TmallOrderItemService tmallOrderItemService;

    private final TmallCartService tmallCartService;

    @Autowired
    public TmallOrderController(TmallOrderService tmallOrderService, TmallOrderItemService tmallOrderItemService, TmallCartService tmallCartService) {
        this.tmallOrderService = tmallOrderService;
        this.tmallOrderItemService = tmallOrderItemService;
        this.tmallCartService = tmallCartService;
    }

    @ApiOperation(value = "订单列表数据获取", notes = "订单列表数据获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid OrderA01InputDTO input) {
        JsonResult<List<TmallOrder>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        params.put("userId", input.getUserId());
        params.put("status", input.getStatus());
        List<TmallOrder> tmallOrderList = tmallOrderService.getAll(params);
        Integer totalCount = tmallOrderService.countGetAll(params);

        jsonResult.setData(tmallOrderList);
        jsonResult.setPage(input.getPage());
        jsonResult.setPageSize(input.getPageSize());
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @ApiOperation(value = "新增订单提交", notes = "新增订单提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid @RequestBody OrderA02InputDTO input) throws BusinessException {
        JsonResult<TmallOrder> jsonResult = new JsonResult<>();

        // 生成订单
        TmallOrder tmallOrder  = BeanMapper.map(input,TmallOrder.class);
        tmallOrder.setOrderNo(UUID.randomUUID().toString().replaceAll("-",""));

        boolean insertOrder = tmallOrderService.insert(tmallOrder);
        if (!insertOrder) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "订单"));
        }

//        // 将购物车的商品添加到订单商品中
//        List<TmallCart> tmallCartList =  tmallCartService.queryByIds(input.getIds(),input.getUserId());
//        List<TmallOrderItem> orderItemList = BeanMapper.mapList(tmallCartList,TmallOrderItem.class);
//
//        for (TmallOrderItem item: orderItemList) {
//            tmallOrderItemService.insert(item);
//        }
        jsonResult.setData(tmallOrder);
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "订单"));
        return jsonResult;
    }

    @ApiOperation(value = "删除订单", notes = "删除指定ID的订单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody OrderA03InputDTO input) throws BusinessException {
        JsonResult<TmallOrder> jsonResult = new JsonResult<>();

        boolean success = tmallOrderService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "订单"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "订单"));
        return jsonResult;
    }

    @ApiOperation(value = "订单编辑提交", notes = "订单编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid @RequestBody OrderA04InputDTO input) throws BusinessException {
        JsonResult<TmallOrder> jsonResult = new JsonResult<>();

        TmallOrder tmallOrder = BeanMapper.map(input, TmallOrder.class);
        boolean success = tmallOrderService.update(tmallOrder);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "订单"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "订单"));
        return jsonResult;
    }

    @ApiOperation(value = "订单查询", notes = "订单详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid OrderA03InputDTO input) throws BusinessException {
        JsonResult<TmallOrder> jsonResult = new JsonResult<>();

        TmallOrder tmallOrder = tmallOrderService.queryById(input.getId());
        if (tmallOrder == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "订单"));
        }
        jsonResult.setData(tmallOrder);
        return jsonResult;
    }

    @ApiOperation(value = "订单支付", notes = "订单支付", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A06")
    public JsonResult A06(@Valid @RequestBody OrderA06InputDTO input) throws BusinessException {
        JsonResult<TmallOrder> jsonResult = new JsonResult<>();

        TmallOrder tmallOrder = BeanMapper.map(input,TmallOrder.class);
        boolean success = tmallOrderService.payOrder(tmallOrder);
        if (!success) {
            throw new BusinessException(new Message("支付失败"));
        }
        jsonResult.setMessage("支付成功");
        return jsonResult;
    }
}

