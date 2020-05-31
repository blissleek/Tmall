package org.blisslee.tmall.api.entity.dto.TmallProductCategory;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 20:50
 */
public class CategoryA02InputDTO {

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sort;

    @ApiModelProperty(value = "父类别id", name = "parentId", dataType = "Integer")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @ApiModelProperty(value = "名称", name = "name", dataType = "String")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "状态", name = "status", dataType = "Integer")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ApiModelProperty(value = "排序", name = "sort", dataType = "Integer")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
