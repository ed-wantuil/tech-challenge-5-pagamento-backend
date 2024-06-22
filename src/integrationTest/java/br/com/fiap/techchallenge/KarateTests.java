package br.com.fiap.techchallenge;

import java.io.IOException;

import br.com.fiap.techchallenge.util.DynamoInit;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Tag("integrationTest")
@Testcontainers
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-testIntegration.yml")
@ActiveProfiles("testIntegration")
public class KarateTests {

    public static final String SQS_QUEUE_PAGAMENTO_NAME = "tech_challenge_pagamento";
    public static final String SQS_QUEUE_PEDIDO_NAME = "tech_challenge_pedido";

    @LocalServerPort
    private int localServerPort;

    @Container
    static LocalStackContainer localStackContainer = new LocalStackContainer(DockerImageName.parse("localstack/localstack:3.2"))
            .withServices(LocalStackContainer.Service.SQS,
                    LocalStackContainer.Service.DYNAMODB);

    @BeforeAll
    public static void beforeAll() throws IOException, InterruptedException {
        localStackContainer.execInContainer("awslocal", "sqs", "create-queue", "--queue-name", SQS_QUEUE_PAGAMENTO_NAME);
        localStackContainer.execInContainer("awslocal", "sqs", "create-queue", "--queue-name", SQS_QUEUE_PEDIDO_NAME);

        final String endpoint = localStackContainer.getEndpointOverride(LocalStackContainer.Service.DYNAMODB).toString();
        System.setProperty("aws.dynamodb.endpoint", endpoint);
        System.setProperty("aws.sqs.endpoint", endpoint);

        final String region = localStackContainer.getRegion();
        System.setProperty("aws.region", region);

        final String accessKey = localStackContainer.getAccessKey();
        System.setProperty("aws.accessKey", accessKey);

        final String secretKey = localStackContainer.getSecretKey();
        System.setProperty("aws.secretKey", secretKey);

        final String sessionToken = localStackContainer.getSecretKey();
        System.setProperty("aws.sessionToken", sessionToken);

        DynamoInit.init(endpoint, region, accessKey, secretKey);
    }

    @Karate.Test
    Karate orderTest() {
        return Karate.run("file:src/integrationTest/java/br/com/fiap/techchallenge/feature/Order.feature")
                .systemProperty("karate.port", String.valueOf(localServerPort));
    }
}
