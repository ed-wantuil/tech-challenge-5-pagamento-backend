package br.com.fiap.techchallenge.frameworks.web.order;

import br.com.fiap.techchallenge.interfaces.controllers.order.requests.UpdatePaymentStatusRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UpdatePaymentStatusWebhook {

    @Operation(summary = "Update delivery status",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order updated"),
            })
    @PostMapping("/order/update-payment-status-webhook")
    void updatePaymentStatus(@RequestBody UpdatePaymentStatusRequest updatePaymentStatusRequest);
}
