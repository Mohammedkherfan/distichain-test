package com.distichain.test.repository;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.enums.CachingKey;

import java.util.List;

public interface CachingRepository {

    void save(String code, ProductBo product);

    List<ProductBo> findAll(CachingKey cachingKey);

    ProductBo find(String code);
}
