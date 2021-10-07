package com.distichain.test.manager;

import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.CreateProductResponse;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.response.UpdateProductResponse;

public interface ProductManager {

    CreateProductResponse create(CreateProductRequest request);

    UpdateProductResponse update(String sku, UpdateProductRequest request);

    GetProductResponse get(String sku);

    void refreshCache();
}
