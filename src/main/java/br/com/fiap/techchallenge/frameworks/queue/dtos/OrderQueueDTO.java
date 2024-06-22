package br.com.fiap.techchallenge.frameworks.queue.dtos;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record OrderQueueDTO(String orderId,
                            String customerId,
                            LocalDate created,
                            Double amount) {
}
