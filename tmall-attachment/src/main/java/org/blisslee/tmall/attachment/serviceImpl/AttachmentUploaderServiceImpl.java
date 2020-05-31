package org.blisslee.tmall.attachment.serviceImpl;

import io.minio.MinioClient;
import org.blisslee.tmall.attachment.entity.Attachment;
import org.blisslee.tmall.attachment.service.AttachmentUploaderService;
import org.blisslee.tmall.attachment.serviceImpl.properties.MinioProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TL
 * @version 1.0.0-RELEASE
 * @since 2020-05-01 5:40 下午
 *
 */
@Component
public class AttachmentUploaderServiceImpl implements AttachmentUploaderService {
    @Autowired
    private MinioProperties minioProperties;

    @Override
    public Attachment uploadMultipartFile(MultipartFile file) throws Exception {
        return uploadStream(file.getOriginalFilename(), file.getInputStream(), file.getContentType());
    }

    @Override
    public Attachment uploadStream(String key, InputStream stream, String contentType) throws Exception {
        MinioClient minioClient = new MinioClient(minioProperties.getEndpoint(), minioProperties.getAccessKey(),
                minioProperties.getAccessSecret());
        boolean isExist = minioClient.bucketExists(minioProperties.getBucket());
        if (!isExist) {
            minioClient.makeBucket(minioProperties.getBucket());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String fileName = minioProperties.getPathPrefix() + "/" + sdf.format(date) + "_" + key;
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        long fileLength = stream.available();

        minioClient.putObject(minioProperties.getBucket(), fileName, stream, contentType);
        String url = minioProperties.getEndpoint() + minioProperties.getBucket() + "/" + fileName;
        return new Attachment(fileName, contentType, extension, url, fileLength);
    }
}
