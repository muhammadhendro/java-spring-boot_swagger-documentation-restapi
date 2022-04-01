package com.hendro.alterra.controller;

import com.hendro.alterra.domain.dto.ProductDto;
import com.hendro.alterra.domain.dto.TransactionDto;
import com.hendro.alterra.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/transactions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Transaction", value = "Transaction", description = "Transaction resource controller")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "")
    @ApiOperation(value = "Get all transactions")
    public ResponseEntity<Object> getAll(){
        return transactionService.getAllTransaction();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get transaction by id")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return transactionService.getTransactionById(id);
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Add new transaction")
    public ResponseEntity<Object> saveTransaction(@RequestBody TransactionDto request) {
        return transactionService.saveTransaction(request);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete transaction by id")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return transactionService.deleteTransaction(id);
    }

    @PutMapping(value= "/{id}")
    @ApiOperation(value = "Update transaction by id")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody TransactionDto request) {
        return transactionService.updateTransactionById(id, request);
    }

}
