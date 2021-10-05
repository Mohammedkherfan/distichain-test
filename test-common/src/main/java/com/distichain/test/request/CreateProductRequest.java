package com.distichain.test.request;

import com.distichain.test.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NotNull(message = "Invalid request")
public class CreateProductRequest {

    @NotNull(message = "Invalid validProducts")
    @NotEmpty(message = "Invalid validProducts")
    private List<ProductDto> products;
}
