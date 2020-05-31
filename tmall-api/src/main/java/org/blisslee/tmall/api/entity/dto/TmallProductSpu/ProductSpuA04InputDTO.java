package org.blisslee.tmall.api.entity.dto.TmallProductSpu;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/6 01:03
 */
public class ProductSpuA04InputDTO {
    @NotNull(message = "ID不能为空")
    private Integer id;

    private Integer productCategoryId;

    private Integer productBrandId;

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    private String subTitle;

    @NotNull(message = "库存不能为空")
    private Integer stock;

    private String mainImage;

    private String albumImages;

    private Integer status;

    @NotBlank(message = "商品详情不能为空")
    private String description;

    private MultipartFile file;

    @ApiModelProperty(value = "ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty(value = "商品分类ID", name = "productCategoryId", dataType = "Integer")
    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @ApiModelProperty(value = "商品品牌ID", name = "productBrandId", dataType = "Integer")
    public Integer getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(Integer productBrandId) {
        this.productBrandId = productBrandId;
    }

    @ApiModelProperty(value = "商品标题", name = "title", dataType = "String")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ApiModelProperty(value = "商品副标题", name = "subTitle", dataType = "String")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @ApiModelProperty(value = "库存", name = "stock", dataType = "Integer")
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @ApiModelProperty(value = "主图", name = "mainImage", dataType = "String")
    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    @ApiModelProperty(value = "商品图片图册", name = "albumImages", dataType = "String")
    public String getAlbumImages() {
        return albumImages;
    }

    public void setAlbumImages(String albumImages) {
        this.albumImages = albumImages;
    }

    @ApiModelProperty(value = "商品状态", name = "status", dataType = "Integer")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ApiModelProperty(value = "商品描述", name = "description", dataType = "String")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ApiModelProperty(value = "价格", name = "price", dataType = "BigDecimal")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ApiModelProperty(value = "文件", name = "file", dataType = "MultipartFile")
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
