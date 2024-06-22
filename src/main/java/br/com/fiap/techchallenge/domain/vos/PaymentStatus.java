package br.com.fiap.techchallenge.domain.vos;


import br.com.fiap.techchallenge.domain.enums.PaymentStatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class PaymentStatus {

    PaymentStatusEnum status;

    public PaymentStatus(final String status) {
        validate(status);

        this.status = PaymentStatusEnum.valueOf(status);
    }

    private void validate(final String status) {
        if (status == null) {
            throw new IllegalArgumentException("Payment status cannot be null");
        }
    }
}
