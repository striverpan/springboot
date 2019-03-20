package com.pan.panspringboot.controller;


import com.pan.panspringboot.domain.DiUser;
import com.pan.panspringboot.utils.hive.HiveUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @PostMapping(value = "login")
    public void login(DiUser user){

    }

}
