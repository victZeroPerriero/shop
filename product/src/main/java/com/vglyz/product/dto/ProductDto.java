package com.vglyz.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    private String nameProduct;
    private Integer price;
}
