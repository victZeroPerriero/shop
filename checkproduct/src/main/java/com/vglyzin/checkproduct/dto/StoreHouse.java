package com.vglyzin.checkproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class StoreHouse {
    private String haveOrNotHave;
    private List<ProductDto> productDtoList;
}
