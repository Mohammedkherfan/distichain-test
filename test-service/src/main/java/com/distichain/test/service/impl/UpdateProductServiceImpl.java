package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.common.ResponseCode;
import com.distichain.test.exception.ProductException;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.UpdateProductResponse;
import com.distichain.test.service.UpdateProductService;

public class UpdateProductServiceImpl implements UpdateProductService {

    private ProductRepository productRepository;

    public UpdateProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public UpdateProductResponse update(String sku, UpdateProductRequest request) {
        validateProduct(sku);
        ProductBo productBo = productRepository.update(ProductBo.builder()
                .sku(sku)
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build());
        return UpdateProductResponse.builder()
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
