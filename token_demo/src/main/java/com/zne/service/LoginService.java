package com.zne.service;

import com.zne.entity.User;

/**
 * @author ZNE
 * @since 2022/9/19
 */
public interface LoginService {
    /**
     * login
     *
     * @param user user
     * @return {@link String}
     * @see String
     */
    String login(User user);

    /**
     * 推出登录
     *
     * @return String
     */
    String logout();
}
