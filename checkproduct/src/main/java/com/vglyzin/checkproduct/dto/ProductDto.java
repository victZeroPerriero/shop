package com.vglyzin.checkproduct.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    private String nameProduct;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer price;
}
