package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
return productRepository.save(product);
    }
    public List<Product> saveProductList(List<Product> product) {
        return productRepository.saveAll(product);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }
    public Optional<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }
    public String deleteProductByid(int id){
         productRepository.deleteById(id);
         return "product removed";
    }
    public Product updateProductById(Product product){
        if(!Objects.isNull(product)) {
            Optional<Product> product1 = productRepository.findById(product.getId());

            if(product1.isPresent()){
                Product  updatableProduct = product1.get();
                updatableProduct.setName(product.getName());

                return productRepository.save(updatableProduct);

            }
        }

return null;



    }
}
