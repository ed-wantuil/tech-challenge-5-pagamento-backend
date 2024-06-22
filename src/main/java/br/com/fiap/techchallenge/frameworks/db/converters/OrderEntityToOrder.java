package br.com.fiap.techchallenge.frameworks.db.converters;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.vos.OrderAmount;
import br.com.fiap.techchallenge.domain.vos.PaymentStatus;
import br.com.fiap.techchallenge.frameworks.db.entities.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderEntityToOrder {


    public Order convert(final OrderEntity orderEntity) {
        return Order
                .builder()
                .orderId(orderEntity.getOrderId().toString())
                .customerId(orderEntity.getCustomerId().toString())
                .paymentStatus(new PaymentStatus(orderEntity.getPaymentStatus()))
                .created(orderEntity.getCreated())
                .amount(new OrderAmount(orderEntity.getAmount()))
                .build();
    }
}
