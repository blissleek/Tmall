package org.blisslee.tmall.api.entity.model;

import java.math.BigDecimal;
import java.util.Date;

public class TmallCart {
    private Integer id;

    private Integer userId;

    private Integer productSkuId;

    private Integer productSpuId;

    private String productName;

    private String productBrand;

    private String productImage;

    private String productProperty;

    private BigDecimal productPrice;

    private BigDecimal productAmount;

    private Integer productQuantity;

    private Date createdAt;

    private Date updatedAt;

    public TmallCart(Integer id, Integer userId, Integer productSkuId, Integer productSpuId, String productName, String productBrand, String productImage, String productProperty, BigDecimal productPrice, BigDecimal productAmount, Integer productQuantity, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userId = userId;
        this.productSkuId = productSkuId;
        this.productSpuId = productSpuId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productImage = productImage;
        this.productProperty = productProperty;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productQuantity = productQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TmallCart() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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