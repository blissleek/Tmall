package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallCart.CartA01InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallCart.CartA02InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallCart.CartA03InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallCart.CartA04InputDTO;
import org.blisslee.tmall.api.entity.model.TmallCart;
import org.blisslee.tmall.api.service.TmallCartService;
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

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 3:51 下午
 */
@Api(tags = "cart API",value = "TmallCartController")
@RestController
@CrossOrigin
@RequestMapping("/cart")
public class TmallCartController {
    private final TmallCartService tmallCartService;


    @Autowired
    public TmallCartController(TmallCartService tmallCartService) {
        this.tmallCartService = tmallCartService;
    }

    @ApiOperation(value = "购物车商品列表数据获取", notes = "用户购物车商品列表数据获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid CartA01InputDTO input) {
        JsonResult<List<TmallCart>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        params.put("userId", input.getUserId());
        List<TmallCart> cartList = tmallCartService.getAll(params);

        jsonResult.setData(cartList);
        return jsonResult;
    }
    @ApiOperation(value = "新增购物车商品提交", notes = "新增购物车商品提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid @RequestBody CartA02InputDTO input) throws BusinessException {
        JsonResult<TmallCart> jsonResult = new JsonResult<>();

        TmallCart tmallCart  = BeanMapper.map(input,TmallCart.class);
        boolean success = tmallCartService.insert(tmallCart);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "购物车商品"));
        }
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "购物车商品"));
        return jsonResult;
    }

    @ApiOperation(value = "删除购物车商品", notes = "删除指定ID的购物车商品", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody CartA03InputDTO input) throws BusinessException {
        JsonResult<TmallCart> jsonResult = new JsonResult<>();

        boolean success = tmallCartService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "购物车商品"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "购物车商品"));
        return jsonResult;
    }

    @ApiOperation(value = "购物车商品编辑提交", notes = "购物车商品编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid @RequestBody CartA04InputDTO input) throws BusinessException {
        JsonResult<TmallCart> jsonResult = new JsonResult<>();

        TmallCart tmallCart = BeanMapper.map(input, TmallCart.class);
        boolean success = tmallCartService.update(tmallCart);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "购物车"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "购物车"));
        return jsonResult;
    }

    @ApiOperation(value = "购物车商品查询", notes = "查询购物车商品详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid CartA03InputDTO input) throws BusinessException {
        JsonResult<TmallCart> jsonResult = new JsonResult<>();

        TmallCart tmallCart = tmallCartService.queryById(input.getId());
        if (tmallCart == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "购物车商品"));
        }
        jsonResult.setData(tmallCart);
        return jsonResult;
    }
}
