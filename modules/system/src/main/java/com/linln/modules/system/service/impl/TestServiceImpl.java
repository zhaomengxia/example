package com.linln.modules.system.service.impl;

import com.linln.common.data.PageSort;
import com.linln.common.enums.StatusEnum;
import com.linln.modules.system.domain.Test;
import com.linln.modules.system.repository.TestRepository;
import com.linln.modules.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 小笨笨
 * @date 2019/05/09
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    /**
     * 根据ID查询数据
     * @param id 主键ID
     */
    @Override
    @Transactional
    public Test getById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    @Override
    public Page<Test> getPageList(Example<Test> example) {
        // 创建分页对象
        PageRequest page = PageSort.pageRequest();
        return testRepository.findAll(example, page);
    }

    /**
     * 保存数据
     * @param test 实体对象
     */
    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Override
    @Transactional
    public Boolean updateStatus(StatusEnum statusEnum, List<Long> idList) {
        return testRepository.updateStatus(statusEnum.getCode(), idList) > 0;
    }
}