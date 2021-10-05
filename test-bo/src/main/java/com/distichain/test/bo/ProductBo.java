package com.distichain.test.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBo {

    private String sku;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
