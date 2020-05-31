package org.blisslee.tmall.attachment.service;

import org.blisslee.tmall.attachment.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author TL
 * @version 1.0.0-RELEASE
 * @since 2020-05-01 5:41 下午
 *
 */
public interface AttachmentUploaderService {

    Attachment uploadMultipartFile(MultipartFile file) throws Exception;

    Attachment uploadStream(String key, InputStream stream, String contentType) throws  Exception;
}
