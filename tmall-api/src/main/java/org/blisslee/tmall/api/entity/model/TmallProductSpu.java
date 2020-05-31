package org.blisslee.tmall.api.entity.model;

import java.math.BigDecimal;
import java.util.Date;

public class TmallProductSpu {
    private Integer id;

    private Integer productCategoryId;

    private Integer productBrandId;

    private String title;

    private String subTitle;

    private Integer stock;

    private String mainImage;

    private String albumImages;

    private Integer status;

    private BigDecimal price;

    private Date createdAt;

    private Date updatedAt;

    private String description;

    public TmallProductSpu(Integer id, Integer productCategoryId, Integer productBrandId, String title, String subTitle, Integer stock, String mainImage, String albumImages, Integer status,BigDecimal price, Date createdAt, Date updatedAt) {
        this.id = id;
        this.productCategoryId = productCategoryId;
        this.productBrandId = productBrandId;
        this.title = title;
        this.subTitle = subTitle;
        this.stock = stock;
        this.mainImage = mainImage;
        this.albumImages = albumImages;
        this.status = status;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TmallProductSpu(Integer id, Integer productCategoryId, Integer productBrandId, String title, String subTitle, Integer stock, String mainImage, String albumImages, Integer status,BigDecimal price, Date createdAt, Date updatedAt, String description) {
        this.id = id;
        this.productCategoryId = productCategoryId;
        this.productBrandId = productBrandId;
        this.title = title;
        this.subTitle = subTitle;
        this.stock = stock;
        this.mainImage = mainImage;
        this.albumImages = albumImages;
        this.status = status;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
    }

    public TmallProductSpu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(Integer productBrandId) {
        this.productBrandId = productBrandId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public String getAlbumImages() {
        return albumImages;
    }

    public void setAlbumImages(String albumImages) {
        this.albumImages = albumImages == null ? null : albumImages.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}