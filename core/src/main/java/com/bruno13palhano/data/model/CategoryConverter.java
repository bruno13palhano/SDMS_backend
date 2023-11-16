package com.bruno13palhano.data.model;

import com.bruno13palhano.model.Category;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class CategoryConverter implements AttributeConverter<List<Category>, String> {

    @Override
    public String convertToDatabaseColumn(List<Category> attribute) {
        if (attribute !=null && !attribute.isEmpty()) {
            return attribute.stream()
                    .map(c -> c.getId()+":"+c.getCategory())
                    .collect(Collectors.joining(", "));
        } else {
            return "";
        }
    }

    @Override
    public List<Category> convertToEntityAttribute(String dbData) {
        if (dbData.isEmpty()) {
            return List.of();
        } else {
            return Arrays.stream(dbData.split(",")).map(s -> {
                String[] params = s.split(":");
                return new Category(Long.parseLong(params[0]), params[1]);
            }).toList();
        }
    }
}
