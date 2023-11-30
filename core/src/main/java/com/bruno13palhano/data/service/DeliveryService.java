package com.bruno13palhano.data.service;

import com.bruno13palhano.data.Repository;
import com.bruno13palhano.data.repository.DeliveryRepository;
import com.bruno13palhano.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeliveryService implements Repository<Delivery> {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void insert(Delivery data) {
        deliveryRepository.insert(data);
    }

    @Override
    public void update(Delivery data) {
        deliveryRepository.update(data);
    }

    @Override
    public void deleteById(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.getAll();
    }
}
