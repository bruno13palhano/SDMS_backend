package com.bruno13palhano.data.service.impl;

import com.bruno13palhano.data.repository.VersionRepository;
import com.bruno13palhano.data.service.VersionService;
import com.bruno13palhano.model.DataVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultVersionService implements VersionService {
    @Autowired
    private VersionRepository versionRepository;

    @Override
    public void insert(DataVersion model) {
        versionRepository.insert(model);
    }

    @Override
    public void update(DataVersion model) {
        versionRepository.update(model);
    }

    @Override
    public void delete(Long id) {
        versionRepository.deleteById(id);
    }

    @Override
    public List<DataVersion> getAll() {
        return versionRepository.getAll();
    }
}
