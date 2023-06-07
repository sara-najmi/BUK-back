package com.sbuk.shopping.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "SELECT * fROM INVOICE WHERE USER_ID = :user_id",nativeQuery = true)
    List<Invoice> findAllByUserId(Integer user_id);
}
