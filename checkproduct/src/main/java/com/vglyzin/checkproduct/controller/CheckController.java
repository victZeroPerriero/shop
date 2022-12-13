package com.vglyzin.checkproduct.controller;

import com.vglyzin.checkproduct.dto.ProductDto;
import com.vglyzin.checkproduct.service.ServiceCheckProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chk/")
@Slf4j
@RequiredArgsConstructor
public class CheckController {
    private final ServiceCheckProduct serviceCheckProduct;

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable("id") Integer id) {
        return serviceCheckProduct.getProduct(id);
    }
    @GetMapping("check/{name}")
    public String checkHave(@PathVariable("name") String name){
        return serviceCheckProduct.checkHaveProduct(name);
    }

}
