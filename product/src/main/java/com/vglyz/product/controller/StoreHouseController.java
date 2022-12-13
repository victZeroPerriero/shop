package com.vglyz.product.controller;

import com.vglyz.product.dto.ProductDto;
import com.vglyz.product.dto.StoreHouseDto;
import com.vglyz.product.service.ServiceStoreHouseProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Slf4j
public class StoreHouseController {

    private final ServiceStoreHouseProduct serviceStoreHouseProduct;

    @GetMapping("allproduct")
    public List<ProductDto> getAllProduct(){
        log.info("get all product in store house{}", serviceStoreHouseProduct.getAllProduct());
        return serviceStoreHouseProduct.getAllProduct();
    }

    @GetMapping("{id}")
    public ProductDto getOneProduct(@PathVariable("id") Integer id) {
        log.info("find by id {}" ,serviceStoreHouseProduct.findById(id));
        return serviceStoreHouseProduct.findById(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDto dto){
        serviceStoreHouseProduct.add(dto);
    }
}
