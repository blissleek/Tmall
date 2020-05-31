package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallOrderItem.OrderItemA01InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallOrderItem.OrderItemA02InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallOrderItem.OrderItemA03InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallOrderItem.OrderItemA04InputDTO;
import org.blisslee.tmall.api.entity.model.TmallOrderItem;
import org.blisslee.tmall.api.service.TmallCartService;
import org.blisslee.tmall.api.service.TmallOrderItemService;
import org.blisslee.tmall.common.BeanMapper;
import org.blisslee.tmall.common.JsonResult;
import org.blisslee.tmall.common.Message;
import org.blisslee.tmall.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 3:53 下午
 */
@Api(tags = "orderItem API",value = "TmallOrderItemController")
@RestController
@CrossOrigin
@RequestMapping("/orderItem")
public class TmallOrderItemController {

    private final TmallOrderItemService tmallOrderItemService;

    @Autowired
    public TmallOrderItemController(TmallOrderItemService tmallOrderItemService) {
        this.tmallOrderItemService = tmallOrderItemService;
    }

    @ApiOperation(value = "订单商品列表数据获取", notes = "订单商品列表数据获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid OrderItemA01InputDTO input) {
        JsonResult<List<TmallOrderItem>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        params.put("orderId", input.getOrderId());
        List<TmallOrderItem> tmallOrderItemList = tmallOrderItemService.getAll(params);

        jsonResult.setData(tmallOrderItemList);
        return jsonResult;
    }

//    @ApiOperation(value = "新增订单商品提交", notes = "新增订单商品提交", produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(method = RequestMethod.POST, value = "/A02")
//    public JsonResult A02(@Valid OrderItemA02InputDTO input) throws BusinessException {
//        JsonResult<TmallOrderItem> jsonResult = new JsonResult<>();
//
//        TmallOrderItem tmallOrderItem  = BeanMapper.map(input,TmallOrderItem.class);
//        tmallOrderItem.setOrderNo(UUID.randomUUID().toString().replaceAll("-",""));
//
//        boolean success = tmallOrderItemService.insert(tmallOrderItem);
//        if (!success) {
//            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "订单商品"));
//        }
//        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "订单商品"));
//        return jsonResult;
//    }
//
//    @ApiOperation(value = "删除订单商品", notes = "删除指定ID的订单商品", produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(method = RequestMethod.POST, value = "/A03")
//    public JsonResult A03(@Valid OrderItemA03InputDTO input) throws BusinessException {
//        JsonResult<TmallOrderItem> jsonResult = new JsonResult<>();
//
//        boolean success = tmallOrderItemService.deleteById(input.getId());
//        if (!success) {
//            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "订单商品"));
//        }
//        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "订单商品"));
//        return jsonResult;
//    }
//
//    @ApiOperation(value = "订单商品编辑提交", notes = "订单商品编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(method = RequestMethod.POST, value = "/A04")
//    public JsonResult A04(@Valid OrderItemA04InputDTO input) throws BusinessException {
//        JsonResult<TmallOrderItem> jsonResult = new JsonResult<>();
//
//        TmallOrderItem tmallOrderItem = BeanMapper.map(input, TmallOrderItem.class);
//        boolean success = tmallOrderItemService.update(tmallOrderItem);
//        if (!success) {
//            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "订单商品"));
//        }
//        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "订单商品"));
//        return jsonResult;
//    }
//
//    @ApiOperation(value = "订单商品查询", notes = "订单商品详情", produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(method = RequestMethod.POST, value = "/A05")
//    public JsonResult A05(@Valid OrderItemA03InputDTO input) throws BusinessException {
//        JsonResult<TmallOrderItem> jsonResult = new JsonResult<>();
//
//        TmallOrderItem tmallOrderItem = tmallOrderItemService.queryById(input.getId());
//        if (tmallOrderItem == null) {
//            throw new BusinessException(new Message("CM.DB.NO_RESULT", "订单商品"));
//        }
//        jsonResult.setData(tmallOrderItem);
//        return jsonResult;
//    }
}
