package org.blisslee.tmall.api.component;

import org.blisslee.tmall.api.service.TmallOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/28 00:16
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    @Autowired
    private TmallOrderService tmallOrderService;

    @RabbitHandler
    public void handle(Integer orderId){
        tmallOrderService.cancelOrder(orderId);
    }
}
