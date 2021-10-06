package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.repository.CachingRepository;
import com.distichain.test.service.CachingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CachingServiceImpl implements CachingService {

    private CachingRepository cachingRepository;

    public CachingServiceImpl(CachingRepository cachingRepository) {
        this.cachingRepository = cachingRepository;
    }

    @Override
    public ProductBo find(String code) {
        return cachingRepository.find(code);
    }

    //@Async
    @Override
    public void save(List<ProductBo> products) {
        products.forEach(productBo -> {
            cachingRepository.save(productBo.getSku(), productBo);
        });
    }
}
