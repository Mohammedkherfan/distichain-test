package com.distichain.test.manager.impl;

import com.distichain.test.manager.ProductManager;
import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.CreateProductResponse;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.response.UpdateProductResponse;
import com.distichain.test.service.CreateProductService;
import com.distichain.test.service.GetProductService;
import com.distichain.test.service.UpdateProductService;

public class ProductManagerImpl implements ProductManager {

    private CreateProductService createProductService;
    private UpdateProductService updateProductService;
    private GetProductService getProductService;

    public ProductManagerImpl(CreateProductService createProductService,
                              UpdateProductService updateProductService,
                              GetProductService getProductService) {
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.getProductService = getProductService;
    }

    @Override
    public CreateProductResponse create(CreateProductRequest request) {
        CreateProductResponse response = createProductService.create(request);
        return response;
    }

    @Override
    public UpdateProductResponse update(String sku, UpdateProductRequest request) {
        UpdateProductResponse response = updateProductService.update(sku, request);
        return response;
    }

    @Override
    public GetProductResponse get(String sku) {
        GetProductResponse response = getProductService.get(sku);
        return response;
    }
}
