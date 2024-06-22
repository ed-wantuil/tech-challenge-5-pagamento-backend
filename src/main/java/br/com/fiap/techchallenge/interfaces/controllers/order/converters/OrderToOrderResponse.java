package br.com.fiap.techchallenge.interfaces.controllers.order.converters;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderToOrderResponse {

    public OrderResponse convert(final Order order) {
        return OrderResponse
                .builder()
                .orderId(order.getOrderId())
                .customerId(order.getCustomerId())
                .paymentStatus(order.getPaymentStatus().getStatus().toString())
                .created(order.getCreated())
                .amount(order.getAmount().amount())
                .build();
    }
}
