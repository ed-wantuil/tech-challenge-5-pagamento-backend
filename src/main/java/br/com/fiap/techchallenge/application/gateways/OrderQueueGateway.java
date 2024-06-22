package br.com.fiap.techchallenge.application.gateways;

import br.com.fiap.techchallenge.domain.entities.Order;

public interface OrderQueueGateway {

    void registerDelivery(Order order);
}
