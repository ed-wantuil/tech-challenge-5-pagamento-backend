package br.com.fiap.techchallenge.interfaces.controllers.order.requests;

import lombok.Builder;

@Builder
public record UpdatePaymentStatusRequest(String id,
                                         String paymentStatus) {
}
