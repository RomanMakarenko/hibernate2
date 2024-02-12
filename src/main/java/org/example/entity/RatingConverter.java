package org.example.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        return Rating.fromValue(s);
    }
}
