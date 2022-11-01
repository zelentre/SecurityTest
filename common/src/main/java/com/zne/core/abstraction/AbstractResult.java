package com.zne.core.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据返回封装顶层抽象类
 *
 * @author ZNE
 * @since 2022/4/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractResult<T> implements Serializable {
    /**
     * 返回消息
     */
    private String message;

    /**
     * 是否成功
     */
    private Boolean success = false;

    /**
     * 响应时间戳
     */
    private String timestamp;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应数据
     */
    private T data;
}
