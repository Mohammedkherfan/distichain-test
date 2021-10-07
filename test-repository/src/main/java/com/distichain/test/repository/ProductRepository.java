package com.distichain.test.repository;

import com.distichain.test.bo.ProductBo;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(List<ProductBo> productBo);

    Optional<ProductBo> findBySku(String sku);

    List<ProductBo> findAll();

    ProductBo update(ProductBo productBo);
}
