package br.com.fiap.techchallenge.application.usecases.order;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.enums.PaymentStatusEnum;

public interface UpdatePaymentStatus {

    Order updatePaymentStatus(String id, PaymentStatusEnum paymentStatus);
}
