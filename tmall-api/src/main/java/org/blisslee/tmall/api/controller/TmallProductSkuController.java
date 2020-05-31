package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallProductSku.ProductSkuA01InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSku.ProductSkuA02InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSku.ProductSkuA03InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSku.ProductSkuA04InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA01InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA02InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA03InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductSpu.ProductSpuA04InputDTO;
import org.blisslee.tmall.api.entity.model.TmallProductSku;
import org.blisslee.tmall.api.entity.model.TmallProductSpu;
import org.blisslee.tmall.api.service.TmallProductSkuService;
import org.blisslee.tmall.api.service.TmallProductSpuService;
import org.blisslee.tmall.attachment.entity.Attachment;
import org.blisslee.tmall.attachment.service.AttachmentUploaderService;
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

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 3:54 下午
 */
@Api(tags = "sku API",value = "TmallProductSkuController")
@RestController
@CrossOrigin
@RequestMapping("/sku")
public class TmallProductSkuController {

    private final TmallProductSkuService tmallProductSkuService;
    private final AttachmentUploaderService attachmentUploaderService;

    @Autowired
    public TmallProductSkuController(TmallProductSkuService tmallProductSkuService, AttachmentUploaderService attachmentUploaderService) {
        this.tmallProductSkuService = tmallProductSkuService;
        this.attachmentUploaderService = attachmentUploaderService;
    }

    @ApiOperation(value = "Sku列表数据获取", notes = "Sku列表数据获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid ProductSkuA01InputDTO input) {
        JsonResult<List<TmallProductSku>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        List<TmallProductSku> productSkuList = tmallProductSkuService.getAll(params);

        jsonResult.setData(productSkuList);
        return jsonResult;
    }

    @ApiOperation(value = "新增Sku提交", notes = "新增Sku提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid ProductSkuA02InputDTO input) throws Exception {
        JsonResult<TmallProductSku> jsonResult = new JsonResult<>();

        TmallProductSku productSku = BeanMapper.map(input, TmallProductSku.class);
        if (input.getFile() != null) {
            Attachment attachment = attachmentUploaderService.uploadMultipartFile(input.getFile());
            productSku.setImage(attachment.getUrl());
        }
        boolean success = tmallProductSkuService.insert(productSku);

        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "Sku"));
        }
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "Sku"));
        return jsonResult;
    }


    @ApiOperation(value = "删除Sku", notes = "删除指定ID的Sku", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid ProductSkuA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        boolean success = tmallProductSkuService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "Sku"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "Sku"));

        return jsonResult;
    }

    @ApiOperation(value = "Sku编辑提交", notes = "Sku编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid ProductSkuA04InputDTO input) throws Exception {
        JsonResult jsonResult = new JsonResult();

        TmallProductSku productSku = BeanMapper.map(input, TmallProductSku.class);
        if (input.getFile() != null) {
            Attachment attachment = attachmentUploaderService.uploadMultipartFile(input.getFile());
            productSku.setImage(attachment.getUrl());
        }
        boolean success = tmallProductSkuService.update(productSku);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "Sku"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "Sku"));
        return jsonResult;
    }

    @ApiOperation(value = "获取Sku", notes = "获取单个Sku详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A05")
    public JsonResult A05(@Valid ProductSkuA03InputDTO input) throws BusinessException {
        JsonResult<TmallProductSku> jsonResult = new JsonResult<>();

        TmallProductSku productSku = tmallProductSkuService.queryById(input.getId());
        if (productSku == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "Sku"));
        }
        jsonResult.setData(productSku);
        return jsonResult;
    }
}
