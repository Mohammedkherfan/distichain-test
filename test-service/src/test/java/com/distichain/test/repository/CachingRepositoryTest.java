package com.distichain.test.repository;

import com.distichain.test.bo.ProductBo;

import java.util.HashMap;
import java.util.Map;

public class CachingRepositoryTest implements CachingRepository {

    private Map<String, ProductBo> map = new HashMap<>();

    @Override
    public void save(String code, ProductBo product) {
        map.put(code, product);
    }

    @Override
    public ProductBo find(String code) {
        return map.get(code);
    }
}
