package br.com.fiap.techchallenge.domain.vos;

public record OrderAmount(Double amount) {
    public OrderAmount {
        validate(amount);

    }

    private void validate(final Double amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
    }
}
