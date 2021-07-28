package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author MrBird
 * @description
 *      1. @Validated：对一般入参添加注解，实体类 上需要加入该注解
 *      2. 对实体类的注解，必须单独加上 @Valid 或者 @Validated
 */
@RestController
@Validated
public class TestController {

    @GetMapping("test1")
    public String test1(
            @NotBlank(message = "{required}") String name,
            @Email(message = "{invalid}") String email) {
        return "success";
    }

    /**
     * 对实体类的注解，必须单独加上 @Valid 或者 @Validated
     * @param user
     * @return
     */
    @GetMapping("test2")
    public String test2(@Valid User user) {
        return "success";
    }
}

