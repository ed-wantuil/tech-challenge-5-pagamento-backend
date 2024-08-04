package br.com.fiap.techchallenge.frameworks.configs;

import java.net.URI;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
@EnableJms
@RequiredArgsConstructor
public class SQSConfig {

    @Value("${aws.region}")
    private final String region;

    @Value("${aws.accessKey}")
    private final String accessKey;

    @Value("${aws.secretKey}")
    private final String secretKey;

    @Value("${aws.sqs.endpoint}")
    private final String endpoint;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(final ConnectionFactory connectionFactory) {
        final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1-2");
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return factory;
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .region(Region.of(region))
                .credentialsProvider(() -> AwsBasicCredentials.create(accessKey, secretKey))
                .endpointOverride(URI.create(endpoint))
                .build();
    }

    @Bean
    public ConnectionFactory connectionFactory(final SqsClient sqsClient) {
        return new SQSConnectionFactory(new ProviderConfiguration(), sqsClient);
    }

}
