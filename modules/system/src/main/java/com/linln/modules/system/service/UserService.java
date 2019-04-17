package com.linln.modules.system.service;

import com.linln.common.enums.StatusEnum;
import com.linln.modules.system.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 小笨笨
 * @date 2018/8/14
 */
public interface UserService {

    /**
     * 获取分页列表数据
     * @param user 实体对象
     * @return 返回分页数据
     */
    Page<User> getPageList(User user);

    /**
     * 保存用户
     * @param user 用户实体类
     */
    User save(User user);

    /**
     * 保存用户列表
     * @param userList 用户实体类
     */
    List<User> save(List<User> userList);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 用户数据
     */
    User getByName(String username);

    /**
     * 根据用户名查询用户数据,且排查指定ID的用户
     * @param username 用户名
     * @param id 排除的用户ID
     * @return 用户数据
     */
    User getByNameAndIdNot(String username, Long id);

    /**
     * 根据用户ID查询用户数据
     * @param id 用户ID
     */
    User getById(Long id);

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> idList);
}
