package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.FindOrderById;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindOrderByIdImpl implements FindOrderById {
    private final OrderGateway orderGateway;

    @Override
    public Order findOrderById(final String id) {
        return orderGateway.findById(id);
    }
}
