package br.com.fiap.techchallenge.frameworks.configs;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.gateways.OrderQueueGateway;
import br.com.fiap.techchallenge.application.usecases.order.CreateOrder;
import br.com.fiap.techchallenge.application.usecases.order.FindOrderById;
import br.com.fiap.techchallenge.application.usecases.order.RegisterDelivery;
import br.com.fiap.techchallenge.application.usecases.order.UpdatePaymentStatus;
import br.com.fiap.techchallenge.application.usecases.order.impl.CreateOrderImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.FindOrderByIdImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.RegisterDeliveryImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.UpdatePaymentStatusImpl;
import br.com.fiap.techchallenge.frameworks.web.order.FindOrderByIdWeb;
import br.com.fiap.techchallenge.frameworks.web.order.UpdatePaymentStatusWebhook;
import br.com.fiap.techchallenge.frameworks.web.order.impl.FindOrderByIdWebImpl;
import br.com.fiap.techchallenge.frameworks.web.order.impl.UpdatePaymentStatusWebhookImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByIdController;
import br.com.fiap.techchallenge.interfaces.controllers.order.UpdatePaymentStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.FindOrderByIdControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.UpdatePaymentStatusControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBean {

    @Bean
    OrderToOrderResponse orderToOrderResponse() {
        return new OrderToOrderResponse();
    }

    @Bean
    UpdatePaymentStatus updatePaymentStatus(final OrderGateway orderGateway, final RegisterDelivery registerDelivery) {
        return new UpdatePaymentStatusImpl(orderGateway, registerDelivery);
    }

    @Bean
    CreateOrder createOrder(final OrderGateway orderGateway) {
        return new CreateOrderImpl(orderGateway);
    }

    @Bean
    RegisterDelivery registerDelivery(final OrderQueueGateway orderQueueGateway) {
        return new RegisterDeliveryImpl(orderQueueGateway);
    }

    @Bean
    UpdatePaymentStatusController updatePaymentStatusController(final UpdatePaymentStatus updatePaymentStatus,
                                                                final OrderToOrderResponse orderToOrderResponse) {
        return new UpdatePaymentStatusControllerImpl(updatePaymentStatus, orderToOrderResponse);
    }

    @Bean
    UpdatePaymentStatusWebhook updatePaymentStatusWebhook(final UpdatePaymentStatusController updatePaymentStatusController) {
        return new UpdatePaymentStatusWebhookImpl(updatePaymentStatusController);
    }

    @Bean
    FindOrderById findOrderById(final OrderGateway orderGateway) {
        return new FindOrderByIdImpl(orderGateway);
    }

    @Bean
    FindOrderByIdController findOrderByIdController(final FindOrderById findOrderById,
                                                    final OrderToOrderResponse orderToOrderResponse) {
        return new FindOrderByIdControllerImpl(findOrderById, orderToOrderResponse);
    }

    @Bean
    FindOrderByIdWeb findOrderByIdWeb(final FindOrderByIdController findOrderByIdController) {
        return new FindOrderByIdWebImpl(findOrderByIdController);
    }
}
