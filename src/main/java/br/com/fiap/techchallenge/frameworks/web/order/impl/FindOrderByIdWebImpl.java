package br.com.fiap.techchallenge.frameworks.web.order.impl;

import br.com.fiap.techchallenge.frameworks.web.order.FindOrderByIdWeb;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByIdController;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindOrderByIdWebImpl implements FindOrderByIdWeb {

    final FindOrderByIdController findOrderByIdController;

    public OrderResponse findOrderById(final String id) {
        return findOrderByIdController.findOrderById(id);
    }
}
