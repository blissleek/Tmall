package org.blisslee.tmall.api.entity.dto.TmallProductCategory;

import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/4 13:39
 */
public class CategoryA01DTO {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sort;

    private List<CategoryA01S01DTO> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<CategoryA01S01DTO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryA01S01DTO> children) {
        this.children = children;
    }
}
