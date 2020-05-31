package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallProductCategory.*;
import org.blisslee.tmall.api.entity.model.TmallProductCategory;
import org.blisslee.tmall.api.service.TmallProductCategoryService;
import org.blisslee.tmall.common.BeanMapper;
import org.blisslee.tmall.common.JsonResult;
import org.blisslee.tmall.common.Message;
import org.blisslee.tmall.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 3:53 下午
 */
@Api(tags = "category API",value = "TmallProductCategoryController")
@RestController
@CrossOrigin
@RequestMapping("/category")
public class TmallProductCategoryController {

    private final TmallProductCategoryService tmallProductCategoryService;

    @Autowired
    public TmallProductCategoryController(TmallProductCategoryService tmallProductCategoryService) {
        this.tmallProductCategoryService = tmallProductCategoryService;
    }

    @ApiOperation(value = "商品分类数据列表获取", notes = "商品分类数据列表获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid CategoryA01InputDTO input) {
        JsonResult<List<TmallProductCategory>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());

        List<TmallProductCategory> productCategoryList = tmallProductCategoryService.getAllCategory(params);
        Integer totalCount = tmallProductCategoryService.countGetAll(params);

        jsonResult.setPage(input.getPage());
        jsonResult.setPageSize(input.getPageSize());
        jsonResult.setTotalCount(totalCount);
        jsonResult.setData(productCategoryList);
        return jsonResult;
    }


    @ApiOperation(value = "新增商品分类提交", notes = "新增商品分类提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid @RequestBody CategoryA02InputDTO input) throws Exception {
        JsonResult<TmallProductCategory> jsonResult = new JsonResult<>();

        TmallProductCategory tmallProductCategory = BeanMapper.map(input, TmallProductCategory.class);
        boolean success = tmallProductCategoryService.insert(tmallProductCategory);

        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "商品分类"));
        }
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "商品分类"));
        return jsonResult;
    }

    @ApiOperation(value = "删除商品分类", notes = "删除指定ID的商品分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody CategoryA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        boolean success = tmallProductCategoryService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "商品分类"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "商品分类"));

        return jsonResult;
    }

    @ApiOperation(value = "商品分类编辑提交", notes = "商品分类编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid @RequestBody CategoryA04InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        TmallProductCategory tmallProductCategory = BeanMapper.map(input, TmallProductCategory.class);
        boolean success = tmallProductCategoryService.update(tmallProductCategory);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "商品分类"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "商品分类"));
        return jsonResult;
    }

    @ApiOperation(value = "商品分类查询", notes = "商品分类详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid CategoryA03InputDTO input) throws BusinessException {
        JsonResult<TmallProductCategory> jsonResult = new JsonResult<>();

        TmallProductCategory tmallProductCategory = tmallProductCategoryService.queryById(input.getId());
        if (tmallProductCategory == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "商品分类"));
        }
        jsonResult.setData(tmallProductCategory);
        return jsonResult;
    }

    @ApiOperation(value = "商品分级分类数据列表获取", notes = "商品分类数据列表获取(目录分级)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JsonResult A06() {
        JsonResult<List<CategoryA01DTO>> jsonResult = new JsonResult<>();

        List<TmallProductCategory> productCategoryList = tmallProductCategoryService.getAll();
        List<CategoryA01DTO> categoryA01DTOList = BeanMapper.mapList(productCategoryList,CategoryA01DTO.class);

        jsonResult.setData(categoryA01DTOList);
        return jsonResult;
    }


}
