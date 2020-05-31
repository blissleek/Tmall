package org.blisslee.tmall.api.entity.dto.TmallOrder;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/10 00:37
 */
public class OrderA04InputDTO {

    @NotNull(message = "订单ID不能为空")
    private Integer id;

    private Integer userId;

    private Integer addressId;

    private Integer status;

    private Integer paymentType;

    private Date paymentTime;

    private Integer deleteStatus;

    private String deliveryCompany;

    private String deliveryNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deliveryTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date receiveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @ApiModelProperty(value = "支付时间", name = "paymentTime", dataType = "Date")
    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    @ApiModelProperty(value = "物流公司(配送方式)", name = "deliveryCompany", dataType = "String")
    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    @ApiModelProperty(value = "物流单号", name = "deliveryNo", dataType = "String")
    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    @ApiModelProperty(value = "发货时间", name = "deliveryTime", dataType = "Date")
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @ApiModelProperty(value = "确认收货时间", name = "receiveTime", dataType = "Date")
    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}
