package org.blisslee.tmall.attachment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author TL
 * @version 1.0.0-RELEASE
 * @since 2020-05-01 5:41 下午
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("org.blisslee.tmall.attachment.serviceImpl")
public class AttachmentServiceImplConfiguration {
}
