package com.distichain.test.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {

    private String sku;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
