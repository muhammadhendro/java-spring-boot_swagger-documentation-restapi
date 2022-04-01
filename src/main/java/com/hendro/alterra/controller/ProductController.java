package com.hendro.alterra.controller;

import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dto.ProductDto;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger.readers.operation.SwaggerOperationTagsReader;

import java.awt.*;

@RestController
@RequestMapping(value = "/v1/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Product", value = "Product", description = "Product resource controller")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "")
    @ApiOperation(value = "Get all products",notes="get all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ProductDto.class),

            @ApiResponse(code = 404, message = "DATA_NOT_FOUND"),

    })
    public ResponseEntity<Object> getAll() {
        return productService.getAllProduct();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get product by id")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Add new product")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto request) {
        return productService.saveProduct(request);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete product by id")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping(value= "/{id}")
    @ApiOperation(value = "Update product by id")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody ProductDto request) {
        return productService.updateProductById(id, request);
    }



}
