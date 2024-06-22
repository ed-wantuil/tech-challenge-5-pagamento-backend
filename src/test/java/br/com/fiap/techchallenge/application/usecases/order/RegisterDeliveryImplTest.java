package br.com.fiap.techchallenge.application.usecases.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.gateways.OrderQueueGateway;
import br.com.fiap.techchallenge.application.usecases.order.impl.FindOrderByIdImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.RegisterDeliveryImpl;
import br.com.fiap.techchallenge.domain.entities.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegisterDeliveryImplTest {

    @Mock
    private OrderQueueGateway orderMessageGateway;

    @InjectMocks
    private RegisterDeliveryImpl registerDelivery;

    @Test
    void testFindOrderById() {
        Order order = Order.builder()
                .customerId("1")
                .build();

        registerDelivery.register(order);

        verify(orderMessageGateway, times(1)).registerDelivery(order);
    }
}
