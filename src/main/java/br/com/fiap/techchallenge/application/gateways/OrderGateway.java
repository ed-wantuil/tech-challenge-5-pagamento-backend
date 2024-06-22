package br.com.fiap.techchallenge.application.gateways;

import br.com.fiap.techchallenge.domain.entities.Order;


public interface OrderGateway {
    Order updatePaymentStatus(String id, String paymentStatus);

    Order findById(String id);

    void create(Order order);
}
