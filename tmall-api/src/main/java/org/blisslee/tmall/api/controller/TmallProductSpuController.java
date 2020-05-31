package org.blisslee.tmall.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.cache.RedisService;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA01InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA02InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA03InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA04InputDTO;
import org.blisslee.tmall.api.entity.model.TmallProductSpu;
import org.blisslee.tmall.api.service.TmallProductSpuService;
import org.blisslee.tmall.attachment.entity.Attachment;
import org.blisslee.tmall.attachment.service.AttachmentUploaderService;
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
@Api(tags = "spu API",value = "TmallProductSpuController")
@RestController
@CrossOrigin
@RequestMapping("/spu")
public class TmallProductSpuController {
    private final TmallProductSpuService tmallProductSpuService;
    private final AttachmentUploaderService attachmentUploaderService;
    private final RedisService redisService;


    @Autowired
    public TmallProductSpuController(TmallProductSpuService tmallProductSpuService, AttachmentUploaderService attachmentUploaderService, RedisService redisService) {
        this.tmallProductSpuService = tmallProductSpuService;
        this.attachmentUploaderService = attachmentUploaderService;
        this.redisService = redisService;
    }


    @ApiOperation(value = "SPU列表数据获取", notes = "SPU列表数据获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid ProductSpuA01InputDTO input) {
        JsonResult<List<TmallProductSpu>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        List<TmallProductSpu> productSpuList = tmallProductSpuService.getAll(params);
        int totalCount = tmallProductSpuService.countGetAll(params);

//        productSpuList.forEach(product -> {
//            try {
//                if (redisService.getCacheValue("product:" + product.getId()) == null) {
//                    redisService.cache("product:" + product.getId(), String.valueOf(product));
//                }
//            } catch (BusinessException e) {
//                e.printStackTrace();
//            }
//        });

        jsonResult.setData(productSpuList);
        jsonResult.setPage(input.getPage());
        jsonResult.setPageSize(input.getPageSize());
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @ApiOperation(value = "新增SPU提交", notes = "新增SPU提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid ProductSpuA02InputDTO input) throws Exception {
        JsonResult<TmallProductSpu> jsonResult = new JsonResult<>();

        TmallProductSpu productSpu = BeanMapper.map(input, TmallProductSpu.class);
        if (input.getFile() != null) {
            Attachment attachment = attachmentUploaderService.uploadMultipartFile(input.getFile());
            productSpu.setMainImage(attachment.getUrl());
        }
        boolean success = tmallProductSpuService.insert(productSpu);

        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "SPU"));
        }
        jsonResult.setData(tmallProductSpuService.queryById(productSpu.getId()));
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "SPU"));
        return jsonResult;
    }


    @ApiOperation(value = "删除SPU", notes = "删除指定ID的SPU", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody ProductSpuA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        boolean success = tmallProductSpuService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "SPU"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "SPU"));

        return jsonResult;
    }

    @ApiOperation(value = "SPU编辑提交", notes = "SPU编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid  ProductSpuA04InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        TmallProductSpu tmallProductSpu = BeanMapper.map(input, TmallProductSpu.class);
        boolean success = tmallProductSpuService.update(tmallProductSpu);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "SPU"));
        }

//        try {
//           redisService.deleteKey("product:" + input.getId());
//           redisService.cache("product:" + input.getId(),JSONObject.toJSONString(tmallProductSpu));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "SPU"));
        return jsonResult;
    }

    @ApiOperation(value = "获取SPU", notes = "获取单个SPU详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid ProductSpuA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult<>();
        TmallProductSpu productSpu;
//        Object object;
//        try {
//            object = JSONObject.toJSON(redisService.getCacheValue("product:" + input.getId()));
//            JSONObject jo = JSON.parseObject(object.toString());
//            jsonResult.setData(jo);
//        } catch (Exception e) {
//            productSpu = tmallProductSpuService.queryById(input.getId());
//            redisService.cache("product:" + productSpu.getId(), JSONObject.toJSONString(productSpu));
//            jsonResult.setData(productSpu);
//
//        }
        productSpu = tmallProductSpuService.queryById(input.getId());
        jsonResult.setData(productSpu);
        return jsonResult;
    }
}
