package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallProductBrand.BrandA01InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductBrand.BrandA02InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductBrand.BrandA03InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallProductBrand.BrandA04InputDTO;
import org.blisslee.tmall.api.entity.model.TmallProductBrand;
import org.blisslee.tmall.api.service.TmallProductBrandService;
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
 * @since 2020/5/3 3:53 下午
 */
@Api(tags = "brand API",value = "TmallProductBrandController")
@RestController
@CrossOrigin
@RequestMapping("/brand")
public class TmallProductBrandController {
    private final AttachmentUploaderService attachmentUploaderService;
    private final TmallProductBrandService tmallProductBrandService;

    @Autowired
    public TmallProductBrandController(AttachmentUploaderService attachmentUploaderService, TmallProductBrandService tmallProductBrandService) {
        this.attachmentUploaderService = attachmentUploaderService;
        this.tmallProductBrandService = tmallProductBrandService;
    }

    @ApiOperation(value = "品牌列表数据获取", notes = "品牌列表数据获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid BrandA01InputDTO input) {
        JsonResult<List<TmallProductBrand>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        List<TmallProductBrand> productBrandList = tmallProductBrandService.getAll(params);
        Integer totalCount = tmallProductBrandService.countGetAll(params);

        jsonResult.setData(productBrandList);
        jsonResult.setPage(input.getPage());
        jsonResult.setPageSize(input.getPageSize());
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @ApiOperation(value = "新增品牌提交", notes = "新增品牌提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid  BrandA02InputDTO input) throws Exception {
        JsonResult<TmallProductBrand> jsonResult = new JsonResult<>();

        TmallProductBrand tmallProductBrand = BeanMapper.map(input, TmallProductBrand.class);
        if (input.getFile() != null) {
            Attachment attachment = attachmentUploaderService.uploadMultipartFile(input.getFile());
            if (attachment == null) {
                throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "品牌图片"));
            }
            tmallProductBrand.setImage(attachment.getUrl());
        }
        boolean success = tmallProductBrandService.insert(tmallProductBrand);

        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "品牌"));
        }
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "品牌"));
        return jsonResult;
    }

    @ApiOperation(value = "删除商品品牌", notes = "删除指定ID的品牌", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody BrandA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        boolean success = tmallProductBrandService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "品牌"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "品牌"));

        return jsonResult;
    }

    @ApiOperation(value = "品牌编辑提交", notes = "品牌编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid  BrandA04InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        TmallProductBrand tmallProductBrand = BeanMapper.map(input, TmallProductBrand.class);
        boolean success = tmallProductBrandService.update(tmallProductBrand);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "品牌"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "品牌"));
        return jsonResult;
    }

    @ApiOperation(value = "品牌查询", notes = "品牌详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid BrandA03InputDTO input) throws BusinessException {
        JsonResult<TmallProductBrand> jsonResult = new JsonResult<>();

        TmallProductBrand tmallProductBrand = tmallProductBrandService.queryById(input.getId());
        if (tmallProductBrand == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "品牌"));
        }
        jsonResult.setData(tmallProductBrand);
        return jsonResult;
    }
}
