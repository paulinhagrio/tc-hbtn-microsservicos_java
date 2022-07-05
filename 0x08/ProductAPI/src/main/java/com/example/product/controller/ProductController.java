package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "- Responsável por retornar uma mensagem de boas vindas")
    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Welcome to our establishment";
    }

    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000")
    @ApiOperation(value = "- Responsável por retornar uma lista de produtos")
    @GetMapping(path = "/allProducts")
    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    @ApiOperation(value = "- Responsável por retornar um produto pelo id")
    @GetMapping(path = "/findProduct/{id}")
    public Product findProductById(@PathVariable Long id){
        return productRepository.getProductById(id);
    }

    @ApiResponse(code = 10, message = "Required fields not informed.")
    @ApiOperation(value = "- Responsável por adicionar um novo produto")
    @PostMapping(path = "/addProduct", consumes = "application/json", produces = "application/json")
    public Product addProduct(@RequestBody Product product){
        productRepository.addProduct(product);
        return product;
    }

    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    @ApiOperation(value = "- Responsável por atualizar um produto")
    @PutMapping(path = "/updateProduct", consumes = "application/json", produces = "application/json")
    public Product updateProduct(@RequestBody Product product){
        productRepository.updateProduct(product);
        return product;
    }

    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    @ApiOperation(value = "- Responsável por remover um produto")
    @DeleteMapping(path = "/removeProduct", consumes = "application/json", produces = "application/json")
    public void deleteProductById(@RequestBody Product product){
        productRepository.removeProduct(product);
    }
}
