package br.com.fiap.techchallenge.frameworks.db.converters;

import java.util.Objects;
import java.util.UUID;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.frameworks.db.entities.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderToOrderEntity {

    public OrderEntity convert(final Order order) {
        return OrderEntity
                .builder()
                .orderId(order.getOrderId())
                .customerId(order.getCustomerId())
                .amount(order.getAmount().amount())
                .paymentStatus(Objects.nonNull(order.getPaymentStatus()) ? order.getPaymentStatus().getStatus().toString() : null)
                .created(order.getCreated())
                .build();
    }
}
