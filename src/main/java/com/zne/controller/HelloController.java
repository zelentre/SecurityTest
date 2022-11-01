package com.zne.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZNE
 * @since 2022/9/15
 */
@RestController
public class HelloController {

    @GetMapping("/h")
    public String hello() {
        return "hello";
    }

}
