package com.distichain.test.manager.impl;

import com.distichain.test.manager.ProductManager;
import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.CreateProductResponse;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.response.UpdateProductResponse;
import com.distichain.test.service.CreateProductService;
import com.distichain.test.service.GetProductService;
import com.distichain.test.service.RefreshCacheService;
import com.distichain.test.service.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductManagerImpl implements ProductManager {

    private CreateProductService createProductService;
    private UpdateProductService updateProductService;
    private GetProductService getProductService;
    private RefreshCacheService refreshCacheService;

    @Autowired
    public ProductManagerImpl(CreateProductService createProductService,
                              UpdateProductService updateProductService,
                              GetProductService getProductService,
                              RefreshCacheService refreshCacheService) {
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.getProductService = getProductService;
        this.refreshCacheService = refreshCacheService;
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

    @Override
    public void refreshCache() {
        refreshCacheService.refreshCache();
    }
}
