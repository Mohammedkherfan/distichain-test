package com.distichain.test.bo;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBo implements Serializable {

    @CsvBindByPosition(position = 0)
    private String sku;
    @CsvBindByPosition(position = 1)
    private String title;
    @CsvBindByPosition(position = 2)
    private String description;
    @CsvBindByPosition(position = 3)
    private BigDecimal price;
    @CsvBindByPosition(position = 4)
    private Integer quantity;
}
