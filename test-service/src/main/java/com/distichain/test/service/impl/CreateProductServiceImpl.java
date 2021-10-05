package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.dto.ProductDto;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.response.CreateProductResponse;
import com.distichain.test.service.CreateProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateProductServiceImpl implements CreateProductService {

    private ProductRepository productRepository;

    public CreateProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public CreateProductResponse create(CreateProductRequest request) {
        List<ProductBo> products = mapProducts(request.getProducts());
        return save(products);
    }

    private CreateProductResponse save(List<ProductBo> products) {
        List<ProductBo> validProducts = new ArrayList<>();
        List<ProductBo> invalidProducts = new ArrayList<>();

        products.forEach(productBo -> {
            Boolean isExist = Boolean.FALSE;//productRepository.existsBySku(productBo.getSku());
            if (isExist) {
                invalidProducts.add(productBo);
            }else {
                validProducts.add(productBo);
            }
        });

        productRepository.save(validProducts);
        return CreateProductResponse.builder()
                .invalidProducts(invalidProducts.stream().map(productBo -> mapToDto(productBo)).collect(Collectors.toList()))
                .validProducts(validProducts.stream().map(productBo -> mapToDto(productBo)).collect(Collectors.toList()))
                .build();
    }

    private ProductDto mapToDto(ProductBo productBo) {
        return ProductDto.builder()
                .sku(productBo.getSku())
                .title(productBo.getTitle())
                .description(productBo.getDescription())
                .price(productBo.getPrice())
                .quantity(productBo.getQuantity())
                .build();
    }

    private List<ProductBo> mapProducts(List<ProductDto> products) {
        return products.stream().map(productDto -> ProductBo.builder()
                .sku(productDto.getSku())
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build())
                .collect(Collectors.toList());
    }
}
