package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderQueueGateway;
import br.com.fiap.techchallenge.application.usecases.order.NotifyOrder;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotifyOrderImpl implements NotifyOrder {

    private final OrderQueueGateway orderQueueGateway;

    public void notify(Order order) {
        orderQueueGateway.notify(order);
    }
}
