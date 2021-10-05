package com.distichain.test.api;

import com.distichain.test.request.CreateProductRequest;
import com.distichain.test.request.UpdateProductRequest;
import com.distichain.test.response.CreateProductResponse;
import com.distichain.test.response.GetProductResponse;
import com.distichain.test.response.UpdateProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping
public interface ProductController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    CreateProductResponse create(CreateProductRequest request);

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    UpdateProductResponse update(String sku, UpdateProductRequest request);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    GetProductResponse get(String sku);
}
