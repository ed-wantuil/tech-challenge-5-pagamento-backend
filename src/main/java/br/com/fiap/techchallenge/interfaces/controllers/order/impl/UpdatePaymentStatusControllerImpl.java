package br.com.fiap.techchallenge.interfaces.controllers.order.impl;

import br.com.fiap.techchallenge.application.usecases.order.UpdatePaymentStatus;
import br.com.fiap.techchallenge.interfaces.controllers.order.UpdatePaymentStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.requests.UpdatePaymentStatusRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdatePaymentStatusControllerImpl implements UpdatePaymentStatusController {

    private final UpdatePaymentStatus updatePaymentStatus;

    private final OrderToOrderResponse orderToOrderResponse;

    public void updatePaymentStatus(final UpdatePaymentStatusRequest updatePaymentStatusRequest) {

        final var order = updatePaymentStatus.updatePaymentStatus(updatePaymentStatusRequest.id(),
                updatePaymentStatusRequest.paymentStatus());

        orderToOrderResponse.convert(order);
    }
}
