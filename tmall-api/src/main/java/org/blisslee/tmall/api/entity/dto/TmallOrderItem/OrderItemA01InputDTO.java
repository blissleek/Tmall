package org.blisslee.tmall.api.entity.dto.TmallOrderItem;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/10 17:30
 */
public class OrderItemA01InputDTO {
    private Integer page = 1;

    private Integer pageSize = 20;

    private Integer orderId;

    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页
     *
     * @param page 当前页
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取 分页大小
     *
     * @return pageSize 分页大小
     */
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 分页大小
     *
     * @param pageSize 分页大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @ApiModelProperty(value = "订单ID", name = "orderId", dataType = "Integer")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
