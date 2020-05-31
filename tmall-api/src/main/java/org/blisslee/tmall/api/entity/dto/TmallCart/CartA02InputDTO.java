package org.blisslee.tmall.api.entity.dto.TmallCart;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/10 17:44
 */
public class CartA02InputDTO {

    @NotNull(message = "用户ID不能为空")
    private Integer userId;

//    private Integer productSkuId;

    @NotNull(message = "商品ID不能为空")
    private Integer productSpuId;

//    private String productName;
//
//    private String productBrand;
//
//    private String productImage;
//
//    private String productProperty;
//
//    private BigDecimal productPrice;
//
//    private BigDecimal productAmount;

    @NotNull(message = "商品数量不能为空")
    private Integer productQuantity;

    @ApiModelProperty(value = "用户id", name = "userId", dataType = "Integer")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

//    @ApiModelProperty(value = "商品sku id", name = "productSkuId", dataType = "Integer")
//    public Integer getProductSkuId() {
//        return productSkuId;
//    }
//
//    public void setProductSkuId(Integer productSkuId) {
//        this.productSkuId = productSkuId;
//    }

    @ApiModelProperty(value = "商品spu id", name = "productSpuId", dataType = "Integer")
    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

//    @ApiModelProperty(value = "商品名称", name = "productName", dataType = "String")
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    @ApiModelProperty(value = "商品品牌", name = "productBrand", dataType = "String")
//    public String getProductBrand() {
//        return productBrand;
//    }
//
//    public void setProductBrand(String productBrand) {
//        this.productBrand = productBrand;
//    }
//
//    @ApiModelProperty(value = "商品图片地址", name = "productImage", dataType = "String")
//    public String getProductImage() {
//        return productImage;
//    }
//
//    public void setProductImage(String productImage) {
//        this.productImage = productImage;
//    }
//
//    @ApiModelProperty(value = "商品属性", name = "productProperty", dataType = "String")
//    public String getProductProperty() {
//        return productProperty;
//    }
//
//    public void setProductProperty(String productProperty) {
//        this.productProperty = productProperty;
//    }
//
//    @ApiModelProperty(value = "商品单价", name = "productPrice", dataType = "BigDecimal")
//    public BigDecimal getProductPrice() {
//        return productPrice;
//    }
//
//    public void setProductPrice(BigDecimal productPrice) {
//        this.productPrice = productPrice;
//    }
//
//    @ApiModelProperty(value = "商品总价", name = "productAmount", dataType = "BigDecimal")
//    public BigDecimal getProductAmount() {
//        return productAmount;
//    }
//
//    public void setProductAmount(BigDecimal productAmount) {
//        this.productAmount = productAmount;
//    }

    @ApiModelProperty(value = "购买数量", name = "productQuantity", dataType = "Integer")
    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
