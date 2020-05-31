package org.blisslee.tmall.api.entity.dto.TmallOrder;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/10 00:15
 */
public class OrderA03InputDTO {
    @NotNull(message = "订单ID不能为空")
    private Integer id;


    @ApiModelProperty(value = "订单ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
