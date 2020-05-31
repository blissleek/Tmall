package org.blisslee.tmall.api.entity.dto.TmallProductSku;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/6 14:41
 */
public class ProductSkuA02InputDTO {

    @NotNull(message = "SpuId不能为空")
    private Integer productSpuId;

    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @NotNull(message = "库存不能为空")
    private Integer stock;

    private String productProperty;

    private MultipartFile file;

    @ApiModelProperty(value = "SpuId", name = "productSpuId", dataType = "Integer")
    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

    @ApiModelProperty(value = "价格", name = "price", dataType = "BigDecimal")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ApiModelProperty(value = "库存", name = "stock", dataType = "Integer")
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    @ApiModelProperty(value = "商品参数", name = "productProperty", dataType = "String")
    public String getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(String productProperty) {
        this.productProperty = productProperty;
    }

    @ApiModelProperty(value = "文件", name = "file", dataType = "MultipartFile")
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
