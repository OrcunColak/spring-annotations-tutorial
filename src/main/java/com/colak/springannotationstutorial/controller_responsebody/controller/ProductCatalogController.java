package com.colak.springannotationstutorial.controller_responsebody.controller;

import com.colak.springannotationstutorial.controller_responsebody.dto.ProductCatalogDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductCatalogController {

    @GetMapping(value = "/ping")
    public String ping() {
        // See https://medium.com/javarevisited/spring-boot-annotations-controller-restcontroller-difference-explained-with-practical-example-813e9d0ce11a
        // There is no @ResponseBody
        // @Controller is primarily employed to create controllers that return views, resolved further by a view resolver.
        // Therefore, when aiming to create REST API that returns JSON or XML Data @ResponseBody annotation needs to be
        // used along with @Controller.
        return "Service : Product Catalog Management : OK";
    }


    @RequestMapping(value = "/productCatalog")
    @ResponseBody
    public List<ProductCatalogDto> getProductCatalog() {
        List<ProductCatalogDto> productCatalogList = new ArrayList<>();

        ProductCatalogDto productCatalog1 = new ProductCatalogDto();
        productCatalog1.setProductName("Product A");
        productCatalog1.setPrice(1000);
        productCatalogList.add(productCatalog1);

        ProductCatalogDto productCatalog2 = new ProductCatalogDto();
        productCatalog2.setProductName("Product B");
        productCatalog2.setPrice(2000);
        productCatalogList.add(productCatalog2);

        return productCatalogList;
    }
}
