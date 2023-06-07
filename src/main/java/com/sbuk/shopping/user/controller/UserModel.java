package com.sbuk.shopping.user.controller;

import com.sbuk.shopping.utility.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel extends GenericEntity {

    private Integer id;

    private String firstname;

    private String lastname;

    private String nationalCode;

    private String uniId;
}
