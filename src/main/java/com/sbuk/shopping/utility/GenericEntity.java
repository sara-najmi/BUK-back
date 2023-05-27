package com.sbuk.shopping.utility;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
public class GenericEntity {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    Date UpdatedAt;
}
