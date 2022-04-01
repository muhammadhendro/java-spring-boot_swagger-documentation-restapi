package com.hendro.alterra.service;

import com.hendro.alterra.domain.dao.CustomerDao;
import com.hendro.alterra.repository.CustomerRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Object> getAllCustomer(){
        List<CustomerDao> daoList = customerRepository.findAll();
        return ResponseUtil.build(daoList, "SUCCESS", HttpStatus.OK);
    }
}
