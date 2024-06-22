package br.com.fiap.techchallenge.frameworks.web.order;

import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FindOrderByIdWeb {

    @Operation(summary = "Find order by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order Resulta"),
            })
    @GetMapping("/order/find-by-id")
    OrderResponse findOrderById(@RequestParam String id);
}
