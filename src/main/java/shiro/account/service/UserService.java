package shiro.account.service;

import shiro.account.entity.UserEntity;
import shiro.account.shiro.AccountToken;

/**
 * 用户接口
 *
 * @author hejq
 * @date 2019/6/27 11:23
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param user 传入的登录用户信息
     * @return token
     */
    AccountToken login(UserEntity user);

    /**
     * 根据user信息生成Token
     *
     * @param user 用户信息
     * @return AccountToken
     */
    AccountToken createToken(UserEntity user);
}
