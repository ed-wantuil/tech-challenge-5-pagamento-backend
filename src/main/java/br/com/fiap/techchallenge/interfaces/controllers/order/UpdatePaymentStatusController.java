package br.com.fiap.techchallenge.interfaces.controllers.order;

import br.com.fiap.techchallenge.interfaces.controllers.order.requests.UpdatePaymentStatusRequest;

public interface UpdatePaymentStatusController {

    void updatePaymentStatus(UpdatePaymentStatusRequest updatePaymentStatusRequest);
}
