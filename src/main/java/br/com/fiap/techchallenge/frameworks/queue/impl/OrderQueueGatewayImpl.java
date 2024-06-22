package br.com.fiap.techchallenge.frameworks.queue.impl;

import br.com.fiap.techchallenge.application.gateways.OrderQueueGateway;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.frameworks.configs.SQSConfig;
import br.com.fiap.techchallenge.frameworks.queue.converters.OrderToOrderQueueDTO;
import br.com.fiap.techchallenge.frameworks.queue.dtos.OrderQueueDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
@RequiredArgsConstructor
public class OrderQueueGatewayImpl implements OrderQueueGateway {

    private final SQSConfig sqsConfig;

    private final OrderToOrderQueueDTO orderToOrderQueueDTO;

    @Value("${aws.sqs.queue.pedido.endpoint}")
    private final String endpoint;

    @Override
    public void registerDelivery(final Order order) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


        final OrderQueueDTO orderQueueDTO = orderToOrderQueueDTO.convert(order);


        try {
            String jsonString = objectMapper.writeValueAsString(orderQueueDTO);

            final SqsClient sqsClient = sqsConfig.sqsClient();

            final SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                    .queueUrl(endpoint)
                    .messageBody(jsonString)
                    .build();

            sqsClient.sendMessage(sendMessageRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
