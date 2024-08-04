package br.com.fiap.techchallenge.application.gateways;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.enums.PaymentStatusEnum;


public interface OrderGateway {
    Order updatePaymentStatus(String id, PaymentStatusEnum paymentStatus);

    Order findById(String id);

    void create(Order order);
}
