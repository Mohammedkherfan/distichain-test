package com.distichain.test.service;

import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.UpdateProductResponse;

public interface UpdateProductService {

    UpdateProductResponse update(String sku, UpdateProductRequest request);
}
