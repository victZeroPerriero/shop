package com.vglyzin.checkproduct.service;

import com.vglyzin.checkproduct.dto.ProductDto;

public interface ServiceCheckProduct {
    ProductDto getProduct(Integer id);
    String checkHaveProduct(String name);
}
