package com.distichain.test.repository;

import com.distichain.test.bo.ProductBo;

public interface CachingRepository {

    void save(String code, ProductBo product);

    ProductBo find(String code);
}
