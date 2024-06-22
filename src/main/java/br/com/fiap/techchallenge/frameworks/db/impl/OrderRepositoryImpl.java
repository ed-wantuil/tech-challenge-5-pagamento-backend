package br.com.fiap.techchallenge.frameworks.db.impl;

import java.util.UUID;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.frameworks.db.converters.OrderEntityToOrder;
import br.com.fiap.techchallenge.frameworks.db.converters.OrderToOrderEntity;
import br.com.fiap.techchallenge.frameworks.db.entities.OrderEntity;
import br.com.fiap.techchallenge.frameworks.db.repositories.SpringDataOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderGateway {

    private final SpringDataOrderRepository springDataOrderRepository;

    private final OrderEntityToOrder orderEntityToOrder;

    private final OrderToOrderEntity orderToOrderEntity;


    @Override
    public Order updatePaymentStatus(final String id, final String paymentStatus) {
        var orderEntity = springDataOrderRepository.findById(id).orElseThrow();

        orderEntity.setPaymentStatus(paymentStatus);
        orderEntity = springDataOrderRepository.save(orderEntity);

        return orderEntityToOrder.convert(orderEntity);
    }

    @Override
    public Order findById(final String id) {
        final var oderEntity = springDataOrderRepository.findById(id).orElseThrow();

        return orderEntityToOrder.convert(oderEntity);
    }

    @Override
    public void create(final Order order) {
        final OrderEntity orderEntity = orderToOrderEntity.convert(order);

        springDataOrderRepository.save(orderEntity);
    }
}
