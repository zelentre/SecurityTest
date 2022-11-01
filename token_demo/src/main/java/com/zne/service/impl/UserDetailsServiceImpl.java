package com.zne.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zne.entity.LoginUser;
import com.zne.entity.User;
import com.zne.mapper.MenuMapper;
import com.zne.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author ZNE
 * @since 2022/9/18
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;
    private final MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUserName, username));
        //如果查询不到数据就通过抛出异常来给出提示
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }
        //TODO 根据用户查询权限信息 添加到LoginUser中
        //封装成UserDetails对象返回
        return new LoginUser(user, menuMapper.selectPermsByUserId(user.getId()));
    }
}
