package com.localshop.customer.controller;

import com.localshop.customer.model.Product;
import com.localshop.customer.services.interfaces.IProductApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductApplicationService productApplicationService;

    @PostMapping("")
    public ResponseEntity<?> addProduct(@RequestBody List<Product> products){
        productApplicationService.addProduct(products);
        return ResponseEntity.status(200).build();
    }
}
