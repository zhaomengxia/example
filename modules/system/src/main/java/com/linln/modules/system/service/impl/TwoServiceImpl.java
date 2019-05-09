package com.linln.modules.system.service.impl;

import com.linln.common.data.PageSort;
import com.linln.common.enums.StatusEnum;
import com.linln.modules.system.domain.Two;
import com.linln.modules.system.repository.TwoRepository;
import com.linln.modules.system.service.TwoService;
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
public class TwoServiceImpl implements TwoService {

    @Autowired
    private TwoRepository twoRepository;

    /**
     * 根据ID查询数据
     * @param id 主键ID
     */
    @Override
    @Transactional
    public Two getById(Long id) {
        return twoRepository.findById(id).orElse(null);
    }

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    @Override
    public Page<Two> getPageList(Example<Two> example) {
        // 创建分页对象
        PageRequest page = PageSort.pageRequest();
        return twoRepository.findAll(example, page);
    }

    /**
     * 保存数据
     * @param two 实体对象
     */
    @Override
    public Two save(Two two) {
        return twoRepository.save(two);
    }

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     */
    @Override
    @Transactional
    public Boolean updateStatus(StatusEnum statusEnum, List<Long> idList) {
        return twoRepository.updateStatus(statusEnum.getCode(), idList) > 0;
    }
}