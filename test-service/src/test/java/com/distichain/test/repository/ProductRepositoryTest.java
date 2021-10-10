package com.distichain.test.repository;

import com.distichain.test.bo.ProductBo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryTest implements ProductRepository {

    private List<ProductBo> list = new ArrayList<>();

    @Override
    public void save(List<ProductBo> productBo) {
        list.addAll(productBo);
    }

    @Override
    public Optional<ProductBo> findBySku(String sku) {
        return list.stream().filter(productBo -> sku.equals(productBo.getSku())).findFirst();
    }

    @Override
    public List<ProductBo> findAll() {
        return list;
    }

    @Override
    public ProductBo update(ProductBo productBo) {
        list.removeIf(product -> productBo.getSku().equals(product.getSku()));
        list.add(productBo);
        return productBo;
    }
}
