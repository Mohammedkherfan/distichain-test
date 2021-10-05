package com.distichain.test.configuration;

import com.distichain.test.manager.ProductManager;
import com.distichain.test.manager.impl.ProductManagerImpl;
import com.distichain.test.repository.ProductRepository;
import com.distichain.test.repository.impl.ProductRepositoryImpl;
import com.distichain.test.service.CreateProductService;
import com.distichain.test.service.GetProductService;
import com.distichain.test.service.UpdateProductService;
import com.distichain.test.service.impl.CreateProductServiceImpl;
import com.distichain.test.service.impl.GetProductServiceImpl;
import com.distichain.test.service.impl.UpdateProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean
    public CreateProductService createProductService(ProductRepository productRepository) {
        return new CreateProductServiceImpl(productRepository);
    }

    @Bean
    public UpdateProductService updateProductService(ProductRepository productRepository) {
        return new UpdateProductServiceImpl(productRepository);
    }

    @Bean
    public GetProductService getProductService(ProductRepository productRepository) {
        return new GetProductServiceImpl(productRepository);
    }

    @Bean
    public ProductManager productManager(CreateProductService createProductService,
                                         UpdateProductService updateProductService,
                                         GetProductService getProductService) {
        return new ProductManagerImpl(createProductService, updateProductService, getProductService);
    }
}
