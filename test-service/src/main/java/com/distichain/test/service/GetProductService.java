package com.distichain.test.service;

import com.distichain.test.response.GetProductResponse;

public interface GetProductService {

    GetProductResponse get(String sku);

}
