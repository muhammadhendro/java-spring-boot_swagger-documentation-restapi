package com.hendro.alterra.service;

import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dto.ProductDto;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public ResponseEntity<Object> getAllProduct() {
        List<ProductDto> dtoList = new ArrayList<>();
        List<ProductDao> daoList = productRepository.findAll();
        for (ProductDao dao : daoList) {
            dtoList.add(ProductDto.builder()
                    .id(dao.getId())
                    .product(dao.getProduct())
                    .name(dao.getName())
                    .description(dao.getDescription())
                    .stock(dao.getStock())
                    .price(dao.getPrice())
                    .build());
        }
        return ResponseUtil.build(dtoList, "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> getProductById(Long id) {
        Optional<ProductDao> productDaoOptional = productRepository.findById(id);
        if(productDaoOptional.isEmpty()){
            return ResponseUtil.build(null,"DATA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }
        return ResponseUtil.build(ProductDto.builder()
                .id(productDaoOptional.get().getId())
                .product(productDaoOptional.get().getProduct())
                .name(productDaoOptional.get().getName())
                .description(productDaoOptional.get().getDescription())
                .stock(productDaoOptional.get().getStock())
                .price(productDaoOptional.get().getPrice())
                .build(), "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> saveProduct(ProductDto request) {
        ProductDao productDao = ProductDao.builder()
                .product(request.getProduct())
                .name(request.getName())
                .description(request.getDescription())
                .stock(request.getStock())
                .price(request.getPrice())
                .build();
        productRepository.save(productDao);
        return ResponseUtil.build(ProductDto.builder()
                .id(productDao.getId())
                .product(productDao.getProduct())
                .name(productDao.getName())
                .description(productDao.getDescription())
                .stock(productDao.getStock())
                .price(productDao.getPrice())
                .build(), "SUCCESS", HttpStatus.OK);

    }

    public ResponseEntity<Object> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return ResponseUtil.build(null, "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> updateProductById(Long id, ProductDto request) {
        Optional<ProductDao> productDaoOptional = productRepository.findById(id);

        if(productDaoOptional.isEmpty()){
            return ResponseUtil.build(null,"DATA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }

        productDaoOptional.ifPresent(res -> {
            res.setName(request.getName());
            res.setProduct(request.getProduct());
            res.setDescription(request.getDescription());
            res.setStock(request.getStock());
            res.setPrice(request.getPrice());
            productRepository.save(res);
        });

        return ResponseUtil.build(ProductDto.builder()
                .id(productDaoOptional.get().getId())
                .product(productDaoOptional.get().getProduct())
                .name(productDaoOptional.get().getName())
                .description(productDaoOptional.get().getDescription())
                .stock(productDaoOptional.get().getStock())
                .price(productDaoOptional.get().getPrice())
                .build(), "SUCCESS", HttpStatus.OK);
    }
}
