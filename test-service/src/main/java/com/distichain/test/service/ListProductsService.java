package com.distichain.test.service;

import com.distichain.test.bo.ProductBo;

import java.util.List;

public interface ListProductsService {

    List<ProductBo> findAll();
}
