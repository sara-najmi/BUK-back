package com.sbuk.shopping.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "SELECT * fROM INVOICE WHERE USER_ID = :user_id", nativeQuery = true)
    List<Invoice> findAllByUserId(Integer user_id);


    @Query(value = "SELECT COUNT(ID) FROM INVOICE", nativeQuery = true)
    Integer countAll();

    @Query(value = "SELECT COUNT(ID) FROM INVOICE WHERE IS_DELIVERED = 1", nativeQuery = true)
    Integer countAllDelivered();

    @Query(value = "SELECT COUNT(ID) FROM INVOICE WHERE IS_DELIVERED = 0", nativeQuery = true)
    Integer countAllNotDelivered();


    @Query(value = "SELECT * FROM INVOICE ORDER BY ID DESC FETCH FIRST 10 ROWS ONLY ", nativeQuery = true)
    List<Invoice> findTop10();
}
