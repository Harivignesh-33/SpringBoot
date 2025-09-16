package com.jvlcode.spring_boot_demo.controllers;


import com.jvlcode.spring_boot_demo.entity.ProductEntity;
import com.jvlcode.spring_boot_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;


//    ? get all products
    @GetMapping
    public List<ProductEntity> getProducts(){
        return productRepository.findAll();
    }

//    ? get single product
    @GetMapping("/{id}")
    public ProductEntity getSingleProduct(@PathVariable Long id ){
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found with the id "+id));
    }
//    ? add product
    @PostMapping
    public ProductEntity addProduct(@RequestBody ProductEntity product){
        return productRepository.save(product);
    }
//    ? delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable  Long id){
        if(!productRepository.existsById(id)){
            return "The product with id "+id+" is not present";
        }
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }
//    ? update product
    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable Long id,@RequestBody ProductEntity product ){
        ProductEntity existingProduct=productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product with the id "+ id +" is not found"));
//        ! update the product by id
        existingProduct.setName(product.getName());
        existingProduct.setQty(product.getQty());

        return productRepository.save(existingProduct);

    }

}
