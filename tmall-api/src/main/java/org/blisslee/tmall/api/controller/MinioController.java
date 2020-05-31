package org.blisslee.tmall.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.blisslee.tmall.attachment.entity.Attachment;
import org.blisslee.tmall.attachment.service.AttachmentUploaderService;
import org.blisslee.tmall.common.JsonResult;
import org.blisslee.tmall.common.Message;
import org.blisslee.tmall.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author TL
 * @version 1.0.0-RELEASE
 * @since 2020-05-01 9:56 下午
 */
@Api(tags = "minio API",value = "MinioController")
@RestController
@CrossOrigin
@RequestMapping("/minio")
public class MinioController {
    private final AttachmentUploaderService attachmentUploaderService;

    @Autowired
    public MinioController(AttachmentUploaderService attachmentUploaderService) {
        this.attachmentUploaderService = attachmentUploaderService;
    }

    @ApiOperation(value = "文件上传", notes = "上传文件到minio服务器", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Attachment> upload(@RequestParam("file") MultipartFile file) throws Exception {
        JsonResult<Attachment> JsonResult = new JsonResult<>();
        Attachment attachment;
        try {
            attachment = attachmentUploaderService.uploadMultipartFile(file);
        } catch (Exception e) {
            throw new BusinessException(new Message("CM.MINIO.UPDATE_FAILED", "文件"));
        }
        JsonResult.setMessage(new Message("CM.MINIO.UPDATE_SUCCESS","文件"));
        JsonResult.setData(attachment);
        return JsonResult;
    }

}
