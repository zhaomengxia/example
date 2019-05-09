package com.linln.admin.system.controller;

import com.linln.admin.system.validator.TestValid;
import com.linln.common.enums.StatusEnum;
import com.linln.common.utils.EntityBeanUtil;
import com.linln.common.utils.ResultVoUtil;
import com.linln.common.utils.StatusUtil;
import com.linln.common.vo.ResultVo;
import com.linln.modules.system.domain.Test;
import com.linln.modules.system.service.TestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 小笨笨
 * @date 2019/05/09
 */
@Controller
@RequestMapping("/system/test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("system:test:index")
    public String index(Model model, Test test) {

        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", match -> match.contains());

        // 获取数据列表
        Example<Test> example = Example.of(test, matcher);
        Page<Test> list = testService.getPageList(example);

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/system/test/index";
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("system:test:add")
    public String toAdd() {
        return "/system/test/add";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:test:edit")
    public String toEdit(@PathVariable("id") Test test, Model model) {
        model.addAttribute("test", test);
        return "/system/test/add";
    }

    /**
     * 保存添加/修改的数据
     * @param valid 验证对象
     */
    @PostMapping({"/add","/edit"})
    @RequiresPermissions({"system:test:add","system:test:edit"})
    @ResponseBody
    public ResultVo save(@Validated TestValid valid, Test test) {
        // 复制保留无需修改的数据
        if (test.getId() != null) {
            Test beTest = testService.getById(test.getId());
            EntityBeanUtil.copyProperties(beTest, test);
        }

        // 保存数据
        testService.save(test);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("system:test:detail")
    public String toDetail(@PathVariable("id") Test test, Model model) {
        model.addAttribute("test",test);
        return "/system/test/detail";
    }

    /**
     * 设置一条或者多条数据的状态
     */
    @RequestMapping("/status/{param}")
    @RequiresPermissions("system:test:status")
    @ResponseBody
    public ResultVo status(
            @PathVariable("param") String param,
            @RequestParam(value = "ids", required = false) List<Long> ids) {
        // 更新状态
        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
        if (testService.updateStatus(statusEnum, ids)) {
            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
        } else {
            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
        }
    }
}