package org.blisslee.tmall.api.component;

import org.blisslee.tmall.api.service.TmallOrderService;
import org.blisslee.tmall.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/27 21:27
 */
@Component
public class OrderTimeOutCancelTask {
    private final  TmallOrderService tmallOrderService;

    @Autowired
    public OrderTimeOutCancelTask(TmallOrderService tmallOrderService) {
        this.tmallOrderService = tmallOrderService;
    }

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/15 * ? * ?")
    private void cancelTimeOutOrder(){
        tmallOrderService.cancelTimeOutOrder();
    }
}
