package com.sbuk.shopping.attribute;

import com.sbuk.shopping.utility.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Attribute")
@Getter
@Setter
public class Attribute extends GenericEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "title")
    private String title;
}
