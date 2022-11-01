package com.zne.controller;

import com.zne.core.domain.BaseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZNE
 * @since 2022/9/15
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
    public String hello() {
        return "hello";
    }

    @PostMapping("/testCors")
    public BaseResult<String> testCors() {
        return BaseResult.ok("testCors");
    }

}
