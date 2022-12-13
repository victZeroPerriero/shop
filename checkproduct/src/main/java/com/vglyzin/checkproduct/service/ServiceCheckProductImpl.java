package com.vglyzin.checkproduct.service;

import com.vglyzin.checkproduct.dto.ProductDto;
import com.vglyzin.checkproduct.dto.StoreHouse;
import com.vglyzin.checkproduct.listcheck.ListCheckForHaveProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceCheckProductImpl implements ServiceCheckProduct {
    private final WebClient webClient;
    @Override
    public ProductDto getProduct(Integer id) {
        Mono<ProductDto> dtoMono =  findProductById(id);
        log.info("recieve request product from remote servera {}", dtoMono.block());
        return dtoMono.block();
    }
    private Mono<ProductDto> findProductById(Integer id){
        return webClient.get().uri("{id}",id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ProductDto.class);
    }

    @Override
    public String checkHaveProduct(String name) {
        StoreHouse storeHouse = new StoreHouse();

        if (checkOnhaveStore(name)) {
            storeHouse.setHaveOrNotHave(ListCheckForHaveProduct.HAVE_PRODUCT_ON_STORE_HOUSE);
            return  storeHouse.getHaveOrNotHave();
        }
        return null;
    }
    private Flux<ProductDto> getFromStoreHouse(){
        return webClient.get()
                  .uri("/allproduct")
                  .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                  .retrieve()
                  .bodyToFlux(ProductDto.class);

    }

    private boolean checkOnhaveStore(String name) {
       List<ProductDto> productDtoList  = getFromStoreHouse().buffer().blockFirst().stream()
                .filter(productDto -> productDto.getNameProduct().equals(name))
                .collect(Collectors.toList());
       log.info("recieve all product from remote call rest api {}", productDtoList);
        for (ProductDto dto :productDtoList) {
            if (dto.getNameProduct().equals(name)) {
                return ListCheckForHaveProduct.IS_HAVE;
            }
        }
       return false;
    }
}
