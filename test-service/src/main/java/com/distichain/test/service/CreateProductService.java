package com.distichain.test.service;

import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.response.CreateProductResponse;

public interface CreateProductService {

    CreateProductResponse create(CreateProductRequest request);
}
