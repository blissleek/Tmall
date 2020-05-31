package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.api.entity.dto.TmallCarousel.CarouselA01InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallCarousel.CarouselA02InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallCarousel.CarouselA03InputDTO;
import org.blisslee.tmall.api.entity.dto.TmallCarousel.CarouselA04InputDTO;
import org.blisslee.tmall.api.entity.model.TmallCarousel;
import org.blisslee.tmall.api.service.TmallCarouselService;
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
 * @since 2020/5/30 00:44
 */
@Api(tags = "Carousel API",value = "TmallCarouselController")
@RestController
@CrossOrigin
@RequestMapping("/carousel")
public class TmallCarouselController {

    private final AttachmentUploaderService attachmentUploaderService;

    private final TmallCarouselService tmallCarouselService;

    @Autowired
    public TmallCarouselController(AttachmentUploaderService attachmentUploaderService, TmallCarouselService tmallCarouselService) {
        this.attachmentUploaderService = attachmentUploaderService;
        this.tmallCarouselService = tmallCarouselService;
    }


    @ApiOperation(value = "轮播图列表数据获取", notes = "轮播图列表数据获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JsonResult A01(@Valid CarouselA01InputDTO input) {
        JsonResult<List<TmallCarousel>> jsonResult = new JsonResult<>();

        HashMap<String, Object> params = new HashMap<>();
        params.put("offset", (input.getPage() - 1) * input.getPageSize());
        params.put("pageSize", input.getPageSize());
        List<TmallCarousel> tmallCarouselList = tmallCarouselService.getAll(params);
        Integer totalCount = tmallCarouselService.countGetAll(params);

        jsonResult.setData(tmallCarouselList);
        jsonResult.setPage(input.getPage());
        jsonResult.setPageSize(input.getPageSize());
        jsonResult.setTotalCount(totalCount);
        return jsonResult;
    }

    @ApiOperation(value = "新增轮播图提交", notes = "新增轮播图提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JsonResult A02(@Valid CarouselA02InputDTO input) throws Exception {
        JsonResult<TmallCarousel> jsonResult = new JsonResult<>();

        TmallCarousel tmallCarousel = BeanMapper.map(input, TmallCarousel.class);
        if (input.getFile() != null) {
            Attachment attachment = attachmentUploaderService.uploadMultipartFile(input.getFile());
            if (attachment == null) {
                throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "轮播图"));
            }
            tmallCarousel.setImage(attachment.getUrl());
        }
        boolean success = tmallCarouselService.insert(tmallCarousel);

        if (!success) {
            throw new BusinessException(new Message("CM.DB.CREATE_CONFLICT", "轮播图"));
        }
        jsonResult.setMessage(new Message("CM.DB.CREATE_SUCCESS", "轮播图"));
        return jsonResult;
    }

    @ApiOperation(value = "删除轮播图", notes = "删除指定ID的轮播图", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JsonResult A03(@Valid @RequestBody CarouselA03InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        boolean success = tmallCarouselService.deleteById(input.getId());
        if (!success) {
            throw new BusinessException(new Message("CM.DB.DELETE_FAILED", "轮播图"));
        }
        jsonResult.setMessage(new Message("CM.DB.DELETE_SUCCESS", "轮播图"));

        return jsonResult;
    }

    @ApiOperation(value = "轮播图编辑提交", notes = "轮播图编辑提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JsonResult A04(@Valid  CarouselA04InputDTO input) throws BusinessException {
        JsonResult jsonResult = new JsonResult();

        TmallCarousel tmallCarousel = BeanMapper.map(input, TmallCarousel.class);
        boolean success = tmallCarouselService.update(tmallCarousel);
        if (!success) {
            throw new BusinessException(new Message("CM.DB.UPDATE_FAILED", "轮播图"));
        }
        jsonResult.setMessage(new Message("CM.DB.UPDATE_SUCCESS", "轮播图"));
        return jsonResult;
    }

    @ApiOperation(value = "轮播图查询", notes = "轮播图详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JsonResult A05(@Valid CarouselA03InputDTO input) throws BusinessException {
        JsonResult<TmallCarousel> jsonResult = new JsonResult<>();

        TmallCarousel tmallCarousel = tmallCarouselService.queryById(input.getId());
        if (tmallCarousel == null) {
            throw new BusinessException(new Message("CM.DB.NO_RESULT", "轮播图"));
        }
        jsonResult.setData(tmallCarousel);
        return jsonResult;
    }
}
