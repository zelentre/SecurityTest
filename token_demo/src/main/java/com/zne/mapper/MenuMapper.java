package com.zne.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zne.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZNE
 * @since 2022/10/31
 */
@Repository
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {


    /**
     * 根据用户ID查询用户权限
     *
     * @param userId 用户ID
     * @return List<String>
     */
    List<String> selectPermsByUserId(Long userId);
}
