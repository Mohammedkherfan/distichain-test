package com.distichain.test.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NotNull(message = "Invalid request")
public class UpdateProductRequest {

    @NotBlank(message = "Invalid title")
    private String title;

    @NotBlank(message = "Invalid description")
    private String description;

    @NotNull(message = "Invalid price")
    private BigDecimal price;

    @NotNull(message = "Invalid quantity")
    private Integer quantity;
}
