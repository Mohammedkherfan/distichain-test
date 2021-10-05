package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.common.ResponseCode;
import com.distichain.test.exception.ProductException;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.service.GetProductService;

public class GetProductServiceImpl implements GetProductService {

    private ProductRepository productRepository;

    public GetProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GetProductResponse get(String sku) {
        validateProduct(sku);
        ProductBo productBo = productRepository.findBySku(sku);
        return GetProductResponse.builder()
                .sku(productBo.getSku())
                .title(productBo.getTitle())
                .description(productBo.getDescription())
                .price(productBo.getPrice())
                .quantity(productBo.getQuantity())
                .build();
    }

    private void validateProduct(String sku) {
        Boolean isExist = productRepository.existsBySku(sku);
        if (!isExist)
            throw new ProductException(ResponseCode.SKU_NOT_EXIST, String.format("Sku not exist %s1", sku));
    }
}
