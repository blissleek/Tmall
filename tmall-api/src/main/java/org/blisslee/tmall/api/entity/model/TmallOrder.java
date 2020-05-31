package org.blisslee.tmall.api.entity.model;

import java.math.BigDecimal;
import java.util.Date;

public class TmallOrder {
    private Integer id;

    private Integer userId;

    private Integer addressId;

    private String orderNo;

    private BigDecimal totalAmount;

    private Integer status;

    private Integer paymentType;

    private Date paymentTime;

    private Integer deleteStatus;

    private String deliveryCompany;

    private String deliveryNo;

    private Date deliveryTime;

    private Date receiveTime;

    private Date createdAt;

    private Date updatedAt;

    public TmallOrder(Integer id, Integer userId, Integer addressId, String orderNo, BigDecimal totalAmount, Integer status, Integer paymentType, Date paymentTime, Integer deleteStatus, String deliveryCompany, String deliveryNo, Date deliveryTime, Date receiveTime, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userId = userId;
        this.addressId = addressId;
        this.orderNo = orderNo;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentType = paymentType;
        this.paymentTime = paymentTime;
        this.deleteStatus = deleteStatus;
        this.deliveryCompany = deliveryCompany;
        this.deliveryNo = deliveryNo;
        this.deliveryTime = deliveryTime;
        this.receiveTime = receiveTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TmallOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany == null ? null : deliveryCompany.trim();
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo == null ? null : deliveryNo.trim();
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
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
}