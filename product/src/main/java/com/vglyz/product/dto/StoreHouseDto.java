package com.vglyz.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class StoreHouseDto {
    private String nameStoreHouse;
    private List<ProductDto> productDtoList;
}
