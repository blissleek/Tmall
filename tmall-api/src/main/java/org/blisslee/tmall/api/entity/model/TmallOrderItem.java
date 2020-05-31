package org.blisslee.tmall.api.entity.model;

import java.math.BigDecimal;
import java.util.Date;

public class TmallOrderItem {
    private Integer id;

    private Integer orderId;

    private String orderNo;

    private Integer productSkuId;

    private Integer productSpuId;

    private String productName;

    private String productBrand;

    private String productImage;

    private String productProperty;

    private BigDecimal productPrice;

    private BigDecimal productAmount;

    private Integer productQuantity;

    private BigDecimal totalPrice;

    private Date createdAt;

    private Date updatedAt;

    public TmallOrderItem(Integer id, Integer orderId, String orderNo, Integer productSkuId, Integer productSpuId, String productName, String productBrand, String productImage, String productProperty, BigDecimal productPrice, BigDecimal productAmount, Integer productQuantity, BigDecimal totalPrice, Date createdAt, Date updatedAt) {
        this.id = id;
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.productSkuId = productSkuId;
        this.productSpuId = productSpuId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productImage = productImage;
        this.productProperty = productProperty;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productQuantity = productQuantity;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TmallOrderItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Integer productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    public String getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(String productProperty) {
        this.productProperty = productProperty == null ? null : productProperty.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}