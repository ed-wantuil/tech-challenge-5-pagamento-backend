package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.RegisterDelivery;
import br.com.fiap.techchallenge.application.usecases.order.UpdatePaymentStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdatePaymentStatusImpl implements UpdatePaymentStatus {

    private final OrderGateway orderGateway;
    private final RegisterDelivery registerDelivery;

    @Override
    public Order updatePaymentStatus(final String id, final String paymentStatus) {

        Order order = orderGateway.updatePaymentStatus(id, paymentStatus);

        registerDelivery.register(order);

        return order;
    }
}
