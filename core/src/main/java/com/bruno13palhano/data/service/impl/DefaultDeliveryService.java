package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.DeliveryRepository;
import com.bruno13palhano.data.service.DeliveryService;
import com.bruno13palhano.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultDeliveryService implements DeliveryService {
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
    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.getAll();
    }
}
