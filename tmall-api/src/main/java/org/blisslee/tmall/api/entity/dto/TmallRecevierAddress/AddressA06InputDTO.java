package org.blisslee.tmall.api.entity.dto.TmallRecevierAddress;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/26 20:30
 */
public class AddressA06InputDTO {
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @ApiModelProperty(value = "用户ID", name = "userId", dataType = "Integer")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
