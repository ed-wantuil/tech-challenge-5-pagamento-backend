package br.com.fiap.techchallenge.frameworks.db.entities;

import java.time.LocalDate;
import java.util.UUID;

import br.com.fiap.techchallenge.frameworks.util.LocalDateConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@DynamoDBTable(tableName = "payment")
@DynamoDBDocument
public class OrderEntity {

    @DynamoDBHashKey(attributeName = "orderId")
    private String orderId;

    @DynamoDBAttribute(attributeName = "customerId")
    private String customerId;

    @DynamoDBAttribute(attributeName = "paymentStatus")
    private String paymentStatus;

    @DynamoDBAttribute(attributeName = "created")
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate created;

    @DynamoDBAttribute(attributeName = "amount")
    private Double amount;

}
