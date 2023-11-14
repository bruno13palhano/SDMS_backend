package com.bruno13palhano.data.repository;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.Utils;
import com.bruno13palhano.data.dao.ProductDAO;
import com.bruno13palhano.model.Product;
import org.springframework.context.annotation.Configuration;

import java.util.stream.StreamSupport;

@Configuration
public class ProductRepository implements Repository<Product> {
    private final ProductDAO productDAO;

    public ProductRepository(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void insert(Product data) {
        productDAO.save(Utils.productAsEntity(data));
    }

    @Override
    public void update(Product data) {
        productDAO.update(Utils.productAsEntity(data));
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public Iterable<Product> getAll() {
        return StreamSupport
                .stream(productDAO.findAll().spliterator(), false)
                .map(Utils::productAsExternal).toList();
    }
}
