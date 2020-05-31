package org.blisslee.tmall.api.entity.dto.TmallOrder;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/9 23:58
 */
public class OrderA02InputDTO {
    private Integer userId;

    private Integer addressId;

    private BigDecimal totalAmount;

    private Integer status = 0;

    private Integer paymentType = 0;

    private Integer deleteStatus = 0;

    private List<Integer> ids;


    @ApiModelProperty(value = "用户ID", name = "userId", dataType = "Integer")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ApiModelProperty(value = "地址ID", name = "addressId", dataType = "Integer")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @ApiModelProperty(value = "订单总金额", name = "totalAmount", dataType = "BigDecimal")
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }


    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @ApiModelProperty(value = "订单状态", name = "status", dataType = "Integer")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ApiModelProperty(value = "支付方式", name = "paymentType", dataType = "Integer")
    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @ApiModelProperty(value = "删除状态", name = "deleteStatus", dataType = "Integer")
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @ApiModelProperty(value = "购物车商品ID", name = "ids", dataType = "List<Integer>")
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
