package com.distichain.test;

import com.distichain.test.bo.ProductBo;
import com.distichain.test.dto.ProductDto;
import com.distichain.test.exception.ProductException;
import com.distichain.test.manager.ProductManager;
import com.distichain.test.manager.impl.ProductManagerImpl;
import com.distichain.test.repository.CachingRepository;
import com.distichain.test.repository.CachingRepositoryTest;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.repository.ProductRepositoryTest;
import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.service.*;
import com.distichain.test.service.impl.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class GetProductTest {

    private ProductManager productManager;

    private CreateProductService createProductService;
    private UpdateProductService updateProductService;
    private GetProductService getProductService;
    private ListProductsService listProductsService;
    private RefreshCacheService refreshCacheService;

    private ProductRepository productRepository;
    private CachingRepository cachingRepository;
    private CachingService cachingService;


    @Before
    public void setUp() throws Exception {
        productRepository = new ProductRepositoryTest();
        cachingRepository = new CachingRepositoryTest();

        cachingService = new CachingServiceImpl(cachingRepository);
        createProductService = new CreateProductServiceImpl(productRepository, cachingService);
        updateProductService = new UpdateProductServiceImpl(productRepository, cachingService);
        getProductService = new GetProductServiceImpl(productRepository, cachingService);
        listProductsService = new ListProductsServiceImpl(productRepository);
        refreshCacheService = new RefreshCacheServiceImpl(cachingService, listProductsService);

        productManager = new ProductManagerImpl(createProductService, updateProductService, getProductService, refreshCacheService);
    }

    @Test(expected = ProductException.class)
    public void whenGetProduct_AndProductNotExist_ThenShouldReturnError() {
        productManager.get("001");
    }

    @Test
    public void whenGetProduct_AndProductAlreadyExistInCache_ThenShouldReturnProduct() {
        productManager.create(CreateProductRequest.builder()
                .products(Arrays.asList(ProductDto.builder()
                        .sku("0001")
                        .description("product description")
                        .title("product title")
                        .quantity(10)
                        .price(new BigDecimal("5.00"))
                        .build()))
                .build());

        GetProductResponse getProductResponse = productManager.get("0001");
        Assert.assertNotNull(getProductResponse);
    }

    @Test
    public void whenGetProduct_AndProductAlreadyExistInFile_ThenShouldReturnProduct() {
        productRepository.save(Arrays.asList(ProductBo.builder()
                .sku("0001")
                .description("product description")
                .title("product title")
                .quantity(10)
                .price(new BigDecimal("5.00"))
                .build()));
        GetProductResponse getProductResponse = productManager.get("0001");
        Assert.assertNotNull(getProductResponse);
    }
}
