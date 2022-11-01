package com.zne;

import com.zne.entity.User;
import com.zne.mapper.MenuMapper;
import com.zne.mapper.UserMapper;
import com.zne.util.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZNE
 * @since 2022/9/18
 */
@SpringBootTest
public class MapperTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private RedisCache redisCache;

    @Test
    void test01() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testSelectPermsByUserId() {
        List<String> list = menuMapper.selectPermsByUserId(2L);
        System.out.println(list);
    }

    @Test
    void test03() {
        Object map = redisCache.getCacheObject("login:" + 1);
        System.out.println(map);
    }
}
