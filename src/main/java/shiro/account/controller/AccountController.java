package shiro.account.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shiro.account.entity.UserEntity;
import shiro.account.result.ResultBean;
import shiro.account.service.UserService;

/**
 * 账户接口
 *
 * @author hejq
 * @date 2019/6/27 11:17
 */
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public ResultBean login(@RequestBody UserEntity user) {
        log.debug("[用户登录] {}", user);
        return ResultBean.success().putObject(userService.login(user));
    }
}
