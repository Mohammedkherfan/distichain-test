package com.distichain.test.service;

import com.distichain.test.bo.ProductBo;

import java.util.List;

public interface CachingService {

    ProductBo find(String code);

    void save(List<ProductBo> products);
}
