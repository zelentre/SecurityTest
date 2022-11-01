package com.zne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ZNE
 * @since 2022/9/15
 */
@SpringBootApplication
public class TokenApplication {
    public static void main(String[] args) {
        disableWarning();
        SpringApplication.run(TokenApplication.class);
    }

    /**
     * JDK11非法反射警告
     * An illegal reflective access operation has occurred 处理
     */
    public static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe = (Unsafe) theUnsafe.get(null);

            Class<?> cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            unsafe.putObjectVolatile(cls, unsafe.staticFieldOffset(logger), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
