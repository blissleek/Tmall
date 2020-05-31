package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallRecevierAddress.*;
import org.blisslee.tmall.api.entity.model.TmallRecevierAddress;
import org.blisslee.tmall.api.service.TmallRecevierAddressService;
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
 * @since 2020/5/3 3:54 下午
 */
@Api(tags = "address API",value = "TmallRecevierAddressController")
@RestController
@CrossOrigin
@RequestMapping("/address")
public class TmallRecevierAddressController {
    private final TmallRecevierAddressService tmallRecevierAddressService;

    @Autowired
    public TmallRecevierAddressController(TmallRecevierAddressService tmallRecevierAddressService) {
        this.tmallRecevierAddressService = tmallRecevierAddressService;
    }

    @ApiOperation(value = "用户收货地址数据列表获取", notes = "用户收货地址数据列表获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid AddressA01InputDTO input) {
        JsonResult<List<TmallRecevierAddress>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("userId", input.getUserId());
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        List<TmallRecevierAddress> recevierAddressList = tmallRecevierAddressService.getAll(params);
        Integer totalCount = tmallRecevierAddressService.countGetAll(params);

        jsonResult.setData(recevierAddressList);
        jsonResult.setPage(input.getPage());
        jsonResult.setPageSize(input.getPageSize());
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @ApiOperation(value = "新增收货地址提交", notes = "新增收货地址提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid @RequestBody AddressA02InputDTO input) throws Exception {
        JsonResult<TmallRecevierAddress> jsonResult = new JsonResult<>();

        TmallRecevierAddress recevierAddress = BeanMapper.map(input, TmallRecevierAddress.class);
        boolean success = tmallRecevierAddressService.insert(recevierAddress);

        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "收货地址"));
        }
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "收货地址"));
        return jsonResult;
    }

    @ApiOperation(value = "删除收货地址", notes = "删除指定ID的收货地址", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody AddressA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        boolean success = tmallRecevierAddressService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "收货地址"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "收货地址"));

        return jsonResult;
    }

    @ApiOperation(value = "收货地址编辑提交", notes = "收货地址编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid @RequestBody AddressA04InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        TmallRecevierAddress recevierAddress = BeanMapper.map(input, TmallRecevierAddress.class);
        boolean success = tmallRecevierAddressService.update(recevierAddress);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "收货地址"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "收货地址"));
        return jsonResult;
    }

    @ApiOperation(value = "获取收货地址", notes = "获取单个收货地址详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid AddressA03InputDTO input) throws BusinessException {
        JsonResult<TmallRecevierAddress> jsonResult = new JsonResult<>();

        TmallRecevierAddress recevierAddress = tmallRecevierAddressService.queryById(input.getId());
        if (recevierAddress == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "收货地址"));
        }
        jsonResult.setData(recevierAddress);
        return jsonResult;
    }

    @ApiOperation(value = "获取默认收货地址", notes = "获取默认收货地址详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JsonResult A06(@Valid AddressA06InputDTO input) throws BusinessException {
        JsonResult<TmallRecevierAddress> jsonResult = new JsonResult<>();
        TmallRecevierAddress recevierAddress = tmallRecevierAddressService.selectDefaultAddress(input.getUserId());
        if (recevierAddress == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "收货地址"));
        }
        jsonResult.setData(recevierAddress);
        return jsonResult;
    }
}
