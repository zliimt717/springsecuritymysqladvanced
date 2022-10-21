package com.example.springsecuritymysqladvanced.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
  @GetMapping(path = "/")
  public String welCome(){
      return "Welcome to SpringSecurityApplication";
  }
}
