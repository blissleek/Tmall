package org.blisslee.tmall.api.entity.dto.TmallOrder;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/28 03:44
 */
public class OrderA06InputDTO {

    private Integer id;

    private Integer paymentType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
}
