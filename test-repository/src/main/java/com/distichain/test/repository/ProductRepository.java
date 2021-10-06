package com.distichain.test.repository;

import com.distichain.test.bo.ProductBo;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Boolean existsBySku(String sku);

    void save(List<ProductBo> productBo);

    Optional<ProductBo> findBySku(String sku);

    ProductBo update(ProductBo productBo);
}
