package org.blisslee.tmall.api.entity.dto.TmallCart;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/10 17:44
 */
public class CartA03InputDTO {
    @NotNull(message = "购物车商品ID不能为空")
    private Integer id;


    @ApiModelProperty(value = "购物车商品ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
