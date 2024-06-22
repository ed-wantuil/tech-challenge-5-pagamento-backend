package br.com.fiap.techchallenge.application.usecases.order;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.impl.FindOrderByIdImpl;
import br.com.fiap.techchallenge.domain.entities.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindOrderByIdImplTest {

    @Mock
    private OrderGateway orderGateway;

    @InjectMocks
    private FindOrderByIdImpl findOrderById;

    @Test
    void testFindOrderById() {
        String orderId = "uniqueId123";
        Order expectedOrder = new Order();
        when(orderGateway.findById(orderId)).thenReturn(expectedOrder);

        Order resultOrder = findOrderById.findOrderById(orderId);

        verify(orderGateway, times(1)).findById(orderId);
        assertEquals(expectedOrder, resultOrder, "O pedido retornado deve ser o mesmo que o esperado.");
    }
}
