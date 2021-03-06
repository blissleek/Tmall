package org.blisslee.tmall.api.entity.dto.TmallProductBrand;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/3 19:07
 */
public class BrandA02InputDTO {
    @NotBlank(message = "名称不能为空")
    private String name;

    private Integer sort;

    private MultipartFile file;

    @ApiModelProperty(value = "名称", name = "name", dataType = "String")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ApiModelProperty(value = "排序", name = "sort", dataType = "Integer")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @ApiModelProperty(value = "文件", name = "file", dataType = "MultipartFile")
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
