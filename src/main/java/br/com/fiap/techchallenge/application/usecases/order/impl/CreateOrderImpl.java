package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.CreateOrder;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOrderImpl implements CreateOrder {

    private final OrderGateway orderGateway;

    @Override
    public void create(final Order order) {
        orderGateway.create(order);
    }
}
