package org.blisslee.tmall.api.entity.dto.TmallProductCategory;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 20:51
 */
public class CategoryA03InputDTO {

    @NotNull(message = "商品分类ID不能为空")
    private Integer id;


    @ApiModelProperty(value = "商品分类ID", name = "id", dataType = "Integer")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
