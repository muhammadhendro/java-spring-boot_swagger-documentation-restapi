package com.hendro.alterra.service;

import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dao.TransactionDao;
import com.hendro.alterra.domain.dto.TransactionDto;
import com.hendro.alterra.repository.TransactionRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<Object> getAllTransaction() {
        List<TransactionDao> daoList = transactionRepository.findAll();
        return ResponseUtil.build(daoList, "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> getTransactionById(Long id) {
        Optional<TransactionDao> transactionDaoOptional = transactionRepository.findById(id);
        if(transactionDaoOptional.isEmpty()){
            return ResponseUtil.build(null, "DATA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }
        return ResponseUtil.build(transactionDaoOptional.get(), "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> saveTransaction(TransactionDto request) {
        TransactionDao transactionDao = TransactionDao.builder()
                .status(request.getStatus())
                .total_price(request.getTotal_price())
                .build();
        transactionRepository.save(transactionDao);
        return ResponseUtil.build(transactionDao, "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
        return ResponseUtil.build(null, "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> updateTransactionById(Long id, TransactionDto request) {
        Optional<TransactionDao> transactionDaoOptional = transactionRepository.findById(id);

        if(transactionDaoOptional.isEmpty()){
            return ResponseUtil.build(null,"DATA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }

        transactionDaoOptional.ifPresent(res -> {
            res.setStatus(request.getStatus());
            res.setTotal_price(request.getTotal_price());
            transactionRepository.save(res);
        });

        return ResponseUtil.build(transactionDaoOptional.get(), "SUCCESS", HttpStatus.OK);
    }
}
