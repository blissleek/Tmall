package org.blisslee.tmall.api.entity.model;

public class TmallProductBrand {
    private Integer id;

    private String name;

    private String image;

    private Integer sort;

    public TmallProductBrand(Integer id, String name, String image, Integer sort) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.sort = sort;
    }

    public TmallProductBrand() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}