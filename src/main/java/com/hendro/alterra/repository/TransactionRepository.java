package com.hendro.alterra.repository;

import com.hendro.alterra.domain.dao.TransactionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDao, Long> {
}
