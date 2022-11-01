package com.zne.controller;

import com.zne.core.domain.BaseResult;
import com.zne.entity.User;
import com.zne.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZNE
 * @since 2022/9/19
 */
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/user/login")
    public BaseResult<String> login(@RequestBody User user) {
        return BaseResult.ok(loginService.login(user));
    }

    @PostMapping("/user/logout")
    public BaseResult<String> logout() {
        return BaseResult.ok(loginService.logout());
    }
}
