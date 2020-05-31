package org.blisslee.tmall.api.entity.dto.TmallProductCategory;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/4 13:40
 */
public class CategoryA01S02DTO {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sort;

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
}
