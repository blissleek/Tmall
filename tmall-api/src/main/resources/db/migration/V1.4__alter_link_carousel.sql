
DROP TABLE IF EXISTS `tmall_carousel`;
CREATE TABLE `tmall_carousel`
(
    `id`    int(11)       NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `title`  VARCHAR(50)  DEFAULT NULL COMMENT '名称',
    `link`   VARCHAR(500)  DEFAULT NULL COMMENT '链接',
    `image` VARCHAR(500)  NOT NULL COMMENT '轮播图图片地址',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='轮播图品牌表';