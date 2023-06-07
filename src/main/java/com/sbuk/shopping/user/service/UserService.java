package com.sbuk.shopping.user.service;

import com.sbuk.shopping.user.controller.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> list() throws Exception;
}
