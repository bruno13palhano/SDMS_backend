package com.bruno13palhano.data;

import com.bruno13palhano.model.Category;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Utils {

    public static List<Category> stringToListOfCategory(String categories) {
        if (categories == null || categories.isEmpty()) {
            return List.of();
        } else {
            try {
                return Arrays.stream(categories.split(",")).map(s -> {
                    String[] params = s.split("&");
                    return new Category(Long.parseLong(params[0]), params[1], params[2]);
                }).toList();
            } catch (NumberFormatException | PatternSyntaxException e) {
                e.printStackTrace();
                return List.of();
            }
        }
    }
}
