package com.bruno13palhano.data;

import com.bruno13palhano.data.model.CategoryEntity;
import com.bruno13palhano.model.Category;

public class Utils {

    public static Category categoryAsExternal(CategoryEntity entity) {
        return new Category(
                entity.getId(),
                entity.getName()
        );
    }

    public static CategoryEntity categoryAsEntity(Category external) {
        return new CategoryEntity(
                external.getId(),
                external.getName()
        );
    }
}
