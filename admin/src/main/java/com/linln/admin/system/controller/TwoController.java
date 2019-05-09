package com.linln.admin.system.controller;

import com.linln.admin.system.validator.TwoValid;
import com.linln.common.enums.StatusEnum;
import com.linln.common.utils.EntityBeanUtil;
import com.linln.common.utils.ResultVoUtil;
import com.linln.common.utils.StatusUtil;
import com.linln.common.vo.ResultVo;
import com.linln.modules.system.domain.Two;
import com.linln.modules.system.service.TwoService;
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
@RequestMapping("/system/two")
public class TwoController {

    @Autowired
    private TwoService twoService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("system:two:index")
    public String index(Model model, Two two) {

        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", match -> match.contains());

        // 获取数据列表
        Example<Two> example = Example.of(two, matcher);
        Page<Two> list = twoService.getPageList(example);

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/system/two/index";
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("system:two:add")
    public String toAdd() {
        return "/system/two/add";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:two:edit")
    public String toEdit(@PathVariable("id") Two two, Model model) {
        model.addAttribute("two", two);
        return "/system/two/add";
    }

    /**
     * 保存添加/修改的数据
     * @param valid 验证对象
     */
    @PostMapping({"/add","/edit"})
    @RequiresPermissions({"system:two:add","system:two:edit"})
    @ResponseBody
    public ResultVo save(@Validated TwoValid valid, Two two) {
        // 复制保留无需修改的数据
        if (two.getId() != null) {
            Two beTwo = twoService.getById(two.getId());
            EntityBeanUtil.copyProperties(beTwo, two);
        }

        // 保存数据
        twoService.save(two);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("system:two:detail")
    public String toDetail(@PathVariable("id") Two two, Model model) {
        model.addAttribute("two",two);
        return "/system/two/detail";
    }

    /**
     * 设置一条或者多条数据的状态
     */
    @RequestMapping("/status/{param}")
    @RequiresPermissions("system:two:status")
    @ResponseBody
    public ResultVo status(
            @PathVariable("param") String param,
            @RequestParam(value = "ids", required = false) List<Long> ids) {
        // 更新状态
        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
        if (twoService.updateStatus(statusEnum, ids)) {
            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
        } else {
            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
        }
    }
}