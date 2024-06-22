package br.com.fiap.techchallenge.frameworks.util;


import java.time.LocalDate;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    @Override
    public String convert(final LocalDate localDate) {
        return localDate.toString();
    }

    @Override
    public LocalDate unconvert(final String string) {
        return LocalDate.parse(string);
    }
}
