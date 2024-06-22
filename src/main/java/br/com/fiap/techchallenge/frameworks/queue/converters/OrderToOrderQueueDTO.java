package br.com.fiap.techchallenge.frameworks.queue.converters;

import java.util.Objects;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.frameworks.queue.dtos.OrderQueueDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderToOrderQueueDTO {

    public OrderQueueDTO convert(final Order order) {
        return OrderQueueDTO
                .builder()
                .orderId(Objects.nonNull(order.getOrderId()) ? order.getOrderId() : null)
                .customerId(Objects.nonNull(order.getCustomerId()) ? order.getCustomerId() : null)
                .amount(order.getAmount().amount())
                .created(order.getCreated())
                .build();
    }
}
