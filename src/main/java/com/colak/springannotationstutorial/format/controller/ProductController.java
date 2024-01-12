package com.colak.springannotationstutorial.format.controller;

import com.colak.springannotationstutorial.format.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {

    // See https://medium.com/@pandaniel/spring-boot-controllers-getmapping-and-complex-objects-bd182ec99f54
    // you can write your @GetMapping in the same way, albeit without the @RequestBody annotation.
    // Spring will cleanly bind your request parameters to your class instance
    @GetMapping("/get")
    public ProductDto getproduct(ProductDto productDto) {
        return productDto;
    }
}
