package org.blisslee.tmall.api.entity.dto.TmallRecevierAddress;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/4 21:56
 */
public class AddressA03InputDTO {
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
