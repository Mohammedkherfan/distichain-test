package com.distichain.test.api.impl;

import com.distichain.test.api.ProductController;
import com.distichain.test.manager.ProductManager;
import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.CreateProductResponse;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.response.UpdateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class ProductControllerImpl implements ProductController {

    private ProductManager productManager;

    @Autowired
    public ProductControllerImpl(ProductManager productManager) {
        this.productManager = productManager;
    }

    @Override
    public CreateProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        return productManager.create(request);
    }

    @Override
    public UpdateProductResponse update(@PathVariable @Valid @NotBlank(message = "Invalid sku") String sku,
                                        @RequestBody @Valid UpdateProductRequest request) {
        return productManager.update(sku, request);
    }

    @Override
    public GetProductResponse get(@PathVariable @Valid @NotBlank(message = "Invalid sku") String sku) {
        return productManager.get(sku);
    }
}
