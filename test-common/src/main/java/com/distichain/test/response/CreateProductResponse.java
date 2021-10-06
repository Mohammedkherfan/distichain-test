package com.distichain.test.response;

import com.distichain.test.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(value = "successAdded")
    private List<ProductDto> validProducts;
    @JsonProperty(value = "failedAdded")
    private List<ProductDto> invalidProducts;
}
