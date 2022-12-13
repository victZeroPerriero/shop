package com.vglyz.product.service;

import com.vglyz.product.dto.ProductDto;
import com.vglyz.product.dto.StoreHouseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceStoreHouseImpl implements ServiceStoreHouseProduct {
    private List<ProductDto> productDtoList = new ArrayList<>();
    {
        productDtoList.add(new ProductDto(1, "Iphone12",80000));
        productDtoList.add(new ProductDto(2,"Huawey", 50576));
    }

    private final StoreHouseDto storeHouseDto = new StoreHouseDto();{
        storeHouseDto.setProductDtoList(productDtoList);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        return storeHouseDto.getProductDtoList();
    }

    @Override
    public ProductDto findById(Integer id) {
        return storeHouseDto.getProductDtoList()
                .stream().filter(product -> product.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public void add(ProductDto dto) {
       storeHouseDto.getProductDtoList().add(dto);
       log.info("add product in store house {}", findById(dto.getId()));
    }
}
