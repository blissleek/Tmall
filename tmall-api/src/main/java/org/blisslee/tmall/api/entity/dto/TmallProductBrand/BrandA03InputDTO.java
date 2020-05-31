package org.blisslee.tmall.api.entity.dto.TmallProductBrand;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 19:20
 */
public class BrandA03InputDTO {
    @NotNull(message = "品牌ID不能为空")
    private Integer id;


    @ApiModelProperty(value = "品牌ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
