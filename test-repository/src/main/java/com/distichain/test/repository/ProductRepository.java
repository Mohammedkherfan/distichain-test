package com.distichain.test.repository;

import com.distichain.test.bo.ProductBo;

import java.util.List;

public interface ProductRepository {

    Boolean existsBySku(String sku);

    void save(List<ProductBo> productBo);

    ProductBo findBySku(String sku);

    ProductBo update(ProductBo productBo);
}
