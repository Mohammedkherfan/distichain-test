package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.service.ListProductsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsServiceImpl implements ListProductsService {

    private ProductRepository productRepository;

    public ListProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductBo> findAll() {
        return productRepository.findAll();
    }
}
