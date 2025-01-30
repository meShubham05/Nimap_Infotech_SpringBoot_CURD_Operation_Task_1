package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        return productService.getAllProducts(page);

        // default mapping for the pages like after the api/products?page=0  we can directly fetch the Product at given Page no or index...
    }

    @GetMapping("/all")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();

        //  to fetch all products
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);

        // to create Products
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id);

        // to get product by id
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);

        // to update the product by id

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

        // to delete product by id
    }
}