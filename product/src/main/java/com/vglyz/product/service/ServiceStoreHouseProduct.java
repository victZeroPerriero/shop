package com.vglyz.product.service;

import com.vglyz.product.dto.ProductDto;
import com.vglyz.product.dto.StoreHouseDto;

import java.util.List;

public interface ServiceStoreHouseProduct {
    List<ProductDto> getAllProduct();
    ProductDto findById(Integer id);
    void add(ProductDto dto);
}
