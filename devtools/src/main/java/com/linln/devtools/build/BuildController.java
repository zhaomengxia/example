package com.linln.devtools.build;

import com.linln.component.shiro.config.CurrentUser;
import com.linln.modules.system.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 小笨笨
 * @date 2018/8/14
 */
@Controller
@RequestMapping("/dev/build")
public class BuildController {

    @GetMapping
    public String index(Model model, @CurrentUser User user){
        Long userId=user.getId();
        System.out.print(userId);
        return "/devtools/build/index";
    }
}
