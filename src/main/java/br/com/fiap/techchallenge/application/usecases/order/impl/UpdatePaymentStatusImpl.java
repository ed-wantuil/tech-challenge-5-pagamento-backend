package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.NotifyOrder;
import br.com.fiap.techchallenge.application.usecases.order.RegisterDelivery;
import br.com.fiap.techchallenge.application.usecases.order.UpdatePaymentStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.enums.PaymentStatusEnum;
import br.com.fiap.techchallenge.domain.vos.PaymentStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdatePaymentStatusImpl implements UpdatePaymentStatus {

    private final OrderGateway orderGateway;
    private final RegisterDelivery registerDelivery;
    private final NotifyOrder notifyOrder;

    @Override
    public Order updatePaymentStatus(final String id, final PaymentStatusEnum paymentStatus) {

        Order order = orderGateway.updatePaymentStatus(id, paymentStatus);

        if (PaymentStatusEnum.PAID == order.getPaymentStatus().getStatus()) {
            order.setDeliveryStatus("RECEIVED");

            registerDelivery.register(order);
        } else if (PaymentStatusEnum.DENIED == order.getPaymentStatus().getStatus()) {
            order.setPaymentStatus(new PaymentStatus("DENIED"));
            order.setDeliveryStatus("CANCELED");
        }

        notifyOrder.notify(order);

        return order;
    }
}
