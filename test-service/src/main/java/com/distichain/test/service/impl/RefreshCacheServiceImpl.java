package com.distichain.test.service.impl;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.service.CachingService;
import com.distichain.test.service.ListProductsService;
import com.distichain.test.service.RefreshCacheService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCacheServiceImpl implements RefreshCacheService {

    private CachingService cachingService;
    private ListProductsService listProductsService;

    public RefreshCacheServiceImpl(CachingService cachingService, ListProductsService listProductsService) {
        this.cachingService = cachingService;
        this.listProductsService = listProductsService;
    }

    @Override
    public void refreshCache() {
        List<ProductBo> list = listProductsService.findAll();
        cachingService.save(list);
    }
}
