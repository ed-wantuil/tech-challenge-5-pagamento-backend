package br.com.fiap.techchallenge.interfaces.controllers.order.responses;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;


@Builder
public record OrderResponse(String orderId,
                            String customerId,
                            List<OrderItemResponse> items,
                            String deliveryStatus,
                            String paymentStatus,
                            LocalDate created,
                            Double amount) {

    @Builder
    public record OrderItemResponse(String product,
                                    Integer quantity,
                                    Double price) {
    }
}
