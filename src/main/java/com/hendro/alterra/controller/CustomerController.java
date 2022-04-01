package com.hendro.alterra.controller;

import com.hendro.alterra.repository.CustomerRepository;
import com.hendro.alterra.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Customer", value = "Customer", description = "Customer resource controller")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "")
    @ApiOperation(value = "Get all customers",notes="get all customer")
    public ResponseEntity<Object> getAll() {
        return customerService.getAllCustomer();
    }


}
