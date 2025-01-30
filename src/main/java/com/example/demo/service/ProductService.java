package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();

        // create method for fetching the products
    }
    public Page<Product> getAllProducts(int page)
    {
        return productRepository.findAll(PageRequest.of(page, 10));

        // default size of the Product Page is 10 means the  11th product will be added to the next Page i.e.  1st page
    }

    public Product createProduct(Product product)
    {
        return productRepository.save(product);

        // product will created and it will added to the database
    }

    public Optional<Product> getProductById(Long id)
    {
        return productRepository.findById(id);

        // fetching the product with help of  product id
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);

        // updating the Product data with the help of product id
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

        // deleting the particular data with the given product id
    }
}