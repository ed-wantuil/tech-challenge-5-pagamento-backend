package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderQueueGateway;
import br.com.fiap.techchallenge.application.usecases.order.RegisterDelivery;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterDeliveryImpl implements RegisterDelivery {

    final OrderQueueGateway orderMessageGateway;

    @Override
    public void register(final Order order) {
        orderMessageGateway.registerDelivery(order);
    }
}
