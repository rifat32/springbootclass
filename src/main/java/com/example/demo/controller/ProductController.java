package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("products")
    public Product addProduct(@RequestBody Product product){
return productService.saveProduct(product);
    }
    @PostMapping("products/all")
    public List<Product> saveProductList(@RequestBody List<Product> product) {
        return productService.saveProductList(product);
    }
    @GetMapping("products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("products/{id}")
    public Optional<Product> getProductByid(@PathVariable("id") int id){
        return productService.getProductById(id);
    }
    @GetMapping("products/name/{name}")
    public Optional<Product> getProductByName(@PathVariable("name") String name){
        return productService.getProductByName(name);
    }
    @DeleteMapping("products/{id}")
    public String deleteProductByid(@PathVariable("id") int id){
    return    productService.deleteProductByid(id);

    }
    @PutMapping("products")
    public Product updateProductById(@RequestBody Product product){

        return productService.updateProductById(product);

    }
}
