package br.com.fiap.techchallenge.frameworks.web.order.impl;

import br.com.fiap.techchallenge.frameworks.web.order.UpdatePaymentStatusWebhook;
import br.com.fiap.techchallenge.interfaces.controllers.order.UpdatePaymentStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.requests.UpdatePaymentStatusRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdatePaymentStatusWebhookImpl implements UpdatePaymentStatusWebhook {

    private final UpdatePaymentStatusController updatePaymentStatusController;

    public void updatePaymentStatus(final UpdatePaymentStatusRequest updatePaymentStatusRequest) {
        updatePaymentStatusController.updatePaymentStatus(updatePaymentStatusRequest);
    }
}
