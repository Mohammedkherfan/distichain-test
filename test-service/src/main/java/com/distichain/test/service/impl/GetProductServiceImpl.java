package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.common.ResponseCode;
import com.distichain.test.exception.ProductException;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.service.CachingService;
import com.distichain.test.service.GetProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class GetProductServiceImpl implements GetProductService {

    private ProductRepository productRepository;
    private CachingService cachingService;

    public GetProductServiceImpl(ProductRepository productRepository,
                                 CachingService cachingService) {
        this.productRepository = productRepository;
        this.cachingService = cachingService;
    }

    @Override
    public GetProductResponse get(String sku) {
        ProductBo productBo = cachingService.find(sku);
        if (!isNull(productBo)) {
            return GetProductResponse.builder()
                    .sku(productBo.getSku())
                    .title(productBo.getTitle())
                    .description(productBo.getDescription())
                    .price(productBo.getPrice())
                    .quantity(productBo.getQuantity())
                    .build();
        }
        Optional<ProductBo> product = productRepository.findBySku(sku);
        if (product.isPresent()) {
            return GetProductResponse.builder()
                    .sku(product.get().getSku())
                    .title(product.get().getTitle())
                    .description(product.get().getDescription())
                    .price(product.get().getPrice())
                    .quantity(product.get().getQuantity())
                    .build();
        }
        throw new ProductException(ResponseCode.SKU_NOT_EXIST, String.format("Sku not exist %s", sku));
    }
}
