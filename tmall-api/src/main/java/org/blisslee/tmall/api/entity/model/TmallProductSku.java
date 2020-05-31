package org.blisslee.tmall.api.entity.model;

import java.math.BigDecimal;
import java.util.Date;

public class TmallProductSku {
    private Integer id;

    private Integer productSpuId;

    private BigDecimal price;

    private Integer stock;

    private String image;

    private String productProperty;

    private Date createdAt;

    private Date updatedAt;

    public TmallProductSku(Integer id, Integer productSpuId, BigDecimal price, Integer stock, String image, String productProperty, Date createdAt, Date updatedAt) {
        this.id = id;
        this.productSpuId = productSpuId;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.productProperty = productProperty;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TmallProductSku() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(String productProperty) {
        this.productProperty = productProperty == null ? null : productProperty.trim();
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