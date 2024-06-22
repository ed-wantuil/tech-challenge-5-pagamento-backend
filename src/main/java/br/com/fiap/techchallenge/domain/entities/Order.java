package br.com.fiap.techchallenge.domain.entities;

import java.time.LocalDate;

import br.com.fiap.techchallenge.domain.vos.OrderAmount;
import br.com.fiap.techchallenge.domain.vos.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Order {
    private String orderId;
    private String customerId;
    private PaymentStatus paymentStatus;
    private LocalDate created;
    private OrderAmount amount;
}
