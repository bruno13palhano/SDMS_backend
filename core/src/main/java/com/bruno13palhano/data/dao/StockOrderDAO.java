package com.bruno13palhano.data.dao;

import com.bruno13palhano.data.model.StockOrderEntity;
import com.bruno13palhano.model.Items;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StockOrderDAO extends CrudRepository<StockOrderEntity, Long> {

    @Query(value = "SELECT S.id, S.product_id, P.name, P.photo, S.date, S.validity, " +
            "P.categories, S.quantity, P.company, " +
            "S.purchase_price, S.sale_price, S.is_ordered_by_customer, S.is_paid " +
            "FROM product_table P INNER JOIN stock_order_table S " +
            "ON(P.id = S.product_id)", nativeQuery = true)
    Iterable<Items> getAll();
}
