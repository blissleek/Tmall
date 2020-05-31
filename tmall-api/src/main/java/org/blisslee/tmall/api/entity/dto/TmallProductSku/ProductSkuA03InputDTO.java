package org.blisslee.tmall.api.entity.dto.TmallProductSku;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/6 14:44
 */
public class ProductSkuA03InputDTO {
    @NotNull(message = "ID不能为空")
    private Integer id;

    @ApiModelProperty(value = "ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
