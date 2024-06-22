package br.com.fiap.techchallenge.application.usecases.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.impl.UpdatePaymentStatusImpl;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.vos.PaymentStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpdatePaymentStatusImplTest {

    @Mock
    private OrderGateway orderGateway;

    @Mock
    private RegisterDelivery registerDelivery;

    @InjectMocks
    private UpdatePaymentStatusImpl updatePaymentStatus;

    @Test
    public void testUpdatePaymentStatus() {
        String orderId = "orderId123";
        String newPaymentStatus = "PAID";
        Order mockUpdatedOrder = new Order();
        mockUpdatedOrder.setOrderId(orderId);

        mockUpdatedOrder.setPaymentStatus(new PaymentStatus(newPaymentStatus)); // Assumindo que Order possui um método setPaymentStatus

        when(orderGateway.updatePaymentStatus(orderId, newPaymentStatus)).thenReturn(mockUpdatedOrder);

        Order resultOrder = updatePaymentStatus.updatePaymentStatus(orderId, newPaymentStatus);

        verify(orderGateway, times(1)).updatePaymentStatus(orderId, newPaymentStatus);
        assertNotNull(resultOrder, "O pedido retornado não deve ser nulo.");
        assertEquals(orderId, resultOrder.getOrderId(), "O ID do pedido retornado deve corresponder ao fornecido.");
        assertEquals(new PaymentStatus(newPaymentStatus).getStatus(), resultOrder.getPaymentStatus().getStatus(), "O status de pagamento do pedido deve ser atualizado para o novo estado.");
    }
}
