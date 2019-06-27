package shiro.account.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shiro.account.entity.UserEntity;
import shiro.account.result.ResultBean;

/**
 * 用户接口
 *
 * @author hejq
 * @date 2019/6/27 11:40
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/loginInfo")
    @RequiresAuthentication
    public ResultBean userInfo() {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return ResultBean.error("登录信息异常");
        }
        return ResultBean.success().putObject(subject.getPrincipal());
    }
}
