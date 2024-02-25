package ru.midas.server.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.midas.server.model.Product;
import ru.midas.server.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/midas/product")
public class ProductController {

    @NonNull
    private ProductService productService;
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.fetchProductList();
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return String.format("Id:%d is deleted successfully.", id);
    }
}