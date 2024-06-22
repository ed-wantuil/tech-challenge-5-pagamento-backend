package br.com.fiap.techchallenge.interfaces.controllers.order.impl;

import br.com.fiap.techchallenge.application.usecases.order.FindOrderById;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByIdController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindOrderByIdControllerImpl implements FindOrderByIdController {

    private final FindOrderById findOrderById;

    private final OrderToOrderResponse orderToOrderResponse;

    public OrderResponse findOrderById(final String id) {
        final var orderEntity = findOrderById.findOrderById(id);

        return orderToOrderResponse.convert(orderEntity);
    }

}
