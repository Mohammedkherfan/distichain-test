package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.common.ResponseCode;
import com.distichain.test.exception.ProductException;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.UpdateProductResponse;
import com.distichain.test.service.CachingService;
import com.distichain.test.service.UpdateProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UpdateProductServiceImpl implements UpdateProductService {

    private ProductRepository productRepository;
    private CachingService cachingService;

    public UpdateProductServiceImpl(ProductRepository productRepository, CachingService cachingService) {
        this.productRepository = productRepository;
        this.cachingService = cachingService;
    }

    @Override
    public UpdateProductResponse update(String sku, UpdateProductRequest request) {
        ProductBo productBo = ProductBo.builder()
                .sku(sku)
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();
        updateCaching(productBo);
        updateFile(productBo);
        return UpdateProductResponse.builder()
                .sku(productBo.getSku())
                .title(productBo.getTitle())
                .description(productBo.getDescription())
                .price(productBo.getPrice())
                .quantity(productBo.getQuantity())
                .build();
    }

    private void updateFile(ProductBo productBo) {
        Optional<ProductBo> product = productRepository.findBySku(productBo.getSku());
        if (product.isPresent())
            productRepository.update(productBo);
        else
            throw new ProductException(ResponseCode.SKU_NOT_EXIST, String.format("Sku not exist %s", productBo.getSku()));
    }

    private void updateCaching(ProductBo productBo) {
        ProductBo product = cachingService.find(productBo.getSku());
        if (!isNull(product))
            cachingService.save(Arrays.asList(productBo));
    }
}
