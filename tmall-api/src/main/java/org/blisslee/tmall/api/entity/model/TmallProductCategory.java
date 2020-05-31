package org.blisslee.tmall.api.entity.model;

import java.util.Date;
import java.util.List;

public class TmallProductCategory {
    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sort;

    private Date createdAt;

    private Date updatedAt;

    private List<TmallProductCategory> children;

    public TmallProductCategory(Integer id, Integer parentId, String name, Integer status, Integer sort, Date createdAt, Date updatedAt) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.status = status;
        this.sort = sort;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TmallProductCategory() {
    }

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
        this.name = name == null ? null : name.trim();
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public List<TmallProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<TmallProductCategory> children) {
        this.children = children;
    }
}