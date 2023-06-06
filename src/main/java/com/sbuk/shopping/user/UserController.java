package com.sbuk.shopping.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public record UserController(UserService userService) {


    @GetMapping("")
    public List<UserModel> list() throws Exception {
        return userService.list();
    }

}
