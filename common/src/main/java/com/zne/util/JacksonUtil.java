package com.zne.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZNE
 * @since 2022/9/16
 */
public class JacksonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    private JacksonUtil() {
    }

    /**
     * json字符串
     *
     * @param data 格式化数据
     * @return json字符串
     */
    public static String toJson(Object data) {
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("{}, {}", data, e.getMessage(), e);
            }
            return null;
        }
    }

    /**
     * Method to deserialize JSON content from given JSON content String.
     *
     * @param content      json string
     * @param valueTypeRef type reference
     * @param <T>          type
     * @return T
     */
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        try {
            return mapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("{}; {}", content, e.getMessage(), e);
            }
            return null;
        }
    }

    /**
     * Method to deserialize JSON content from given JSON content String.
     *
     * @param content   json string
     * @param valueType value class type
     * @param <T>       type
     * @return type
     */
    public static <T> T readValue(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("{}; {}", content, e.getMessage(), e);
            }
            return null;
        }
    }
}
