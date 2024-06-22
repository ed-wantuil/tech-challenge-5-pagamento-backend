package br.com.fiap.techchallenge.interfaces.controllers.order;

import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;

public interface FindOrderByIdController {

    OrderResponse findOrderById(String id);
}
