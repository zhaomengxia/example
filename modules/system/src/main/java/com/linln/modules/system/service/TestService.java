package com.linln.modules.system.service;

import com.linln.common.enums.StatusEnum;
import com.linln.modules.system.domain.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 小笨笨
 * @date 2019/05/09
 */
public interface TestService {

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    Page<Test> getPageList(Example<Test> example);

    /**
     * 根据ID查询数据
     * @param id 主键ID
     */
    Test getById(Long id);

    /**
     * 保存数据
     * @param test 实体对象
     */
    Test save(Test test);

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> idList);
}