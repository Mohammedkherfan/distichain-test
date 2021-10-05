package com.distichain.test.response;

import com.distichain.test.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponse {

    private List<ProductDto> validProducts;
    private List<ProductDto> invalidProducts;
}
