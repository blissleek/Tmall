SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tmall_user`;
CREATE TABLE `tmall_user`
(
    `id`         int(11)     NOT NULL AUTO_INCREMENT COMMENT '用户表id',
    `user_name`  varchar(50) NOT NULL COMMENT '用户名',
    `password`   varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
    `email`      varchar(50)          DEFAULT NULL,
    `phone`      varchar(20)          DEFAULT NULL,
    `role`       int(1)      NOT NULL DEFAULT '0' COMMENT '角色 0:管理员 1:普通用户',
    `created_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_user_name` (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

DROP TABLE IF EXISTS `tmall_product_category`;
CREATE TABLE `tmall_product_category`
(
    `id`         int(11)  NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `parent_id`  int(11)           DEFAULT NULL COMMENT '父类别id,当id=0时是根节点,一级类别',
    `name`       varchar(50)       DEFAULT NULL COMMENT '类别名称',
    `status`     int(1)            DEFAULT '1' COMMENT '类别状态1:正常,0:已废弃',
    `sort`       int(6)            DEFAULT NULL COMMENT '排序指数，越小越靠前,数值相等则自然排序',
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品分类表';

DROP TABLE IF EXISTS `tmall_product_brand`;
CREATE TABLE `tmall_product_brand`
(
    `id`    int(11)      NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `name`  VARCHAR(50)  NOT NULL COMMENT '名称',
    `image` VARCHAR(256) NOT NULL COMMENT '品牌图片地址',
    `sort`  int(6) DEFAULT NULL COMMENT '排序指数，越小越靠前,数值相等则自然排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品品牌表';

DROP TABLE IF EXISTS `tmall_product_spu`;
CREATE TABLE `tmall_product_spu`
(
    `id`                  int(11)     NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `product_category_id` int(11)              DEFAULT NULL COMMENT '商品分类ID',
    `product_brand_id`    int(11)              DEFAULT NULL COMMENT '商品品牌ID',
    `title`               VARCHAR(50) NOT NULL COMMENT '标题',
    `sub_title`           VARCHAR(100)         DEFAULT NULL COMMENT '副标题',
    `stock`               int(11)     NOT NULL DEFAULT '0' COMMENT '库存',
    `description`         text        NOT NULL COMMENT '商品详情',
    `main_image`          varchar(256)         DEFAULT NULL COMMENT '产品主图地址',
    `album_images`        varchar(1024)        DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
    `status`              int(1)               DEFAULT '1' COMMENT '商品状态.1:在售 2:下架 3:已删除',
    `created_at`          datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`          datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品SPU(Standard Product Unit)表';

DROP TABLE IF EXISTS `tmall_product_sku`;
CREATE TABLE `tmall_product_sku`
(
    `id`               int(11)        NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `product_spu_id`   int(11)                 DEFAULT NULL COMMENT '商品的spu ID',
    `price`            decimal(20, 2) NOT NULL COMMENT '价格,保留两位小数',
    `stock`            int(11)                 DEFAULT '0' COMMENT '库存',
    `image`            varchar(256)            DEFAULT NULL COMMENT '产品图片地址',
    `product_property` varchar(1000)           DEFAULT NULL COMMENT '商品销售属性，json格式',
    `created_at`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品SKU(Stock Keeping Unit)表';


DROP TABLE IF EXISTS `tmall_cart`;
CREATE TABLE `tmall_cart`
(
    `id`               int(11)  NOT NULL AUTO_INCREMENT COMMENT 'Id',
    `user_id`          int(11)           DEFAULT NULL COMMENT '用户id',
    `product_sku_id`   int(11)           DEFAULT NULL COMMENT '商品sku id',
    `product_spu_id`   int(11)           DEFAULT NULL COMMENT '商品spu id',
    `product_name`     varchar(100)      DEFAULT NULL COMMENT '商品名称',
    `product_brand`    varchar(200)      DEFAULT NULL COMMENT '商品品牌',
    `product_image`    varchar(500)      DEFAULT NULL COMMENT '商品图片地址',
    `product_property` varchar(1000)     DEFAULT NULL COMMENT '商品属性，json格式',
    `product_price`    decimal(20, 2)    DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
    `product_amount`   decimal(20, 2)    DEFAULT NULL COMMENT '商品总价，单位是元,保留两位小数',
    `product_quantity` int(11)           DEFAULT NULL COMMENT '购买数量',
    `created_at`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='购物车表';


DROP TABLE IF EXISTS `tmall_order`;
CREATE TABLE `tmall_order`
(
    `id`               int(11)  NOT NULL AUTO_INCREMENT COMMENT '订单id',
    `user_id`          int(11)           DEFAULT NULL COMMENT '用户id',
    `address_id`       int(11)           DEFAULT NULL COMMENT '地址id',
    `order_no`         varchar(128)      DEFAULT NULL COMMENT '订单编号',
    `total_amount`     decimal(20, 2)    DEFAULT NULL COMMENT '订单总金额',
    `status`           int(1)            DEFAULT NULL COMMENT '订单状态：0:待付款；1:待发货；2:已发货；3:已完成；4:已关闭；',
    `payment_type`     int(1)            DEFAULT NULL COMMENT '支付方式：0:未支付；1:支付宝；2:微信,3:银行卡',
    `payment_time`     datetime          DEFAULT NULL COMMENT '支付时间',
    `delete_status`    int(1)   NOT NULL DEFAULT '0' COMMENT '删除状态：0:未删除；1:已删除',
    `delivery_company` varchar(64)       DEFAULT NULL COMMENT '物流公司(配送方式)',
    `delivery_no`      varchar(64)       DEFAULT NULL COMMENT '物流单号',
    `delivery_time`    datetime          DEFAULT NULL COMMENT '发货时间',
    `receive_time`     datetime          DEFAULT NULL COMMENT '确认收货时间',
    `created_at`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='订单表';

DROP TABLE IF EXISTS `tmall_order_item`;
CREATE TABLE `tmall_order_item`
(
    `id`               int(11)  NOT NULL AUTO_INCREMENT,
    `order_id`         int(11)           DEFAULT NULL COMMENT '订单id',
    `order_no`         varchar(128)      DEFAULT NULL COMMENT '订单编号',
    `product_sku_id`   int(11)           DEFAULT NULL COMMENT '商品sku id',
    `product_spu_id`   int(11)           DEFAULT NULL COMMENT '商品spu id',
    `product_name`     varchar(100)      DEFAULT NULL COMMENT '商品名称',
    `product_brand`    varchar(200)      DEFAULT NULL COMMENT '商品品牌',
    `product_image`    varchar(500)      DEFAULT NULL COMMENT '商品图片地址',
    `product_property` varchar(1000)     DEFAULT NULL COMMENT '商品销售属性，json格式',
    `product_price`    decimal(20, 2)    DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
    `product_amount`   decimal(20, 2)    DEFAULT NULL COMMENT '商品总价，单位是元,保留两位小数',
    `product_quantity` int(11)           DEFAULT NULL COMMENT '购买数量',
    `total_price`      decimal(20, 2)    DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
    `created_at`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='订单中所包含的商品';


DROP TABLE IF EXISTS `tmall_recevier_address`;
CREATE TABLE `tmall_recevier_address`
(
    `id`                      int(11)  NOT NULL AUTO_INCREMENT,
    `user_id`                 int(11)           DEFAULT NULL COMMENT '用户id',
    `receiver_name`           varchar(20)       DEFAULT NULL COMMENT '收货姓名',
    `receiver_phone`          varchar(20)       DEFAULT NULL COMMENT '收货人电话',
    `receiver_province`       varchar(20)       DEFAULT NULL COMMENT '省份',
    `receiver_city`           varchar(20)       DEFAULT NULL COMMENT '城市',
    `receiver_region`         varchar(20)       DEFAULT NULL COMMENT '区/县',
    `receiver_detail_address` varchar(256)      DEFAULT NULL COMMENT '详细地址',
    `note`                    varchar(500)      DEFAULT NULL COMMENT '订单备注',
    `created_at`              datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`              datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='收货地址表';

# 启动外键约束.
SET FOREIGN_KEY_CHECKS = 1;