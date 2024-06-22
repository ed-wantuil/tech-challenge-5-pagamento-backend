package br.com.fiap.techchallenge.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class DynamoInit {
    private static final String TABLE_NAME = "payment";
    private static final String COLUMN_KEY = "orderId";

    public static void init(final String endpoint, final String region, final String accessKey, final String secretKey) {

        final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);

        final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .build();

        createTable(client);
        createItems(client);
    }

    private static void createTable(final AmazonDynamoDB client) {
        client.createTable(new CreateTableRequest()
                .withAttributeDefinitions(new AttributeDefinition(COLUMN_KEY, ScalarAttributeType.S))
                .withKeySchema(new KeySchemaElement(COLUMN_KEY, KeyType.HASH))
                .withProvisionedThroughput(new ProvisionedThroughput(10L, 10L))
                .withTableName(TABLE_NAME));
    }

    private static void createItems(final AmazonDynamoDB client) {
        final DynamoDB dynamoDB = new DynamoDB(client);

        final Table table = dynamoDB.getTable(TABLE_NAME);

        Item item = new Item().withPrimaryKey(COLUMN_KEY, "39341acf-e277-4285-9910-52e5f0961248")
                .withString("customerId", "846024fa-be87-408c-91e8-e812008eb424")
                .withString("paymentStatus", "PAID")
                .withString("created", "2024-05-01")
                .withDouble("amount", 10);

        table.putItem(item);

        item = new Item().withPrimaryKey(COLUMN_KEY, "2d0c39b6-1dba-4825-a7c7-9e8378950832")
                .withString("customerId", "d32e25fd-d011-48d3-9fd8-0aab976bf71e")
                .withString("paymentStatus", "WAITING")
                .withString("created", "2024-05-01")
                .withDouble("amount", 10);

        table.putItem(item);
    }
}
