package shiro.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiro.account.entity.UserEntity;
import shiro.account.exception.BusinessException;
import shiro.account.service.UserService;
import shiro.account.shiro.AccountToken;
import shiro.account.shiro.JwtUtil;


/**
 * @author hejq
 * @date 2019/6/27 11:24
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntity userEntity;

    /**
     * 用户登录
     *
     * @param user 传入的登录用户信息
     */
    @Override
    public AccountToken login(UserEntity user) {
        if (!user.getAccount().equals(userEntity.getAccount()) || !user.getPassword().equals(userEntity.getPassword())) {
            throw new BusinessException("账号或密码错误");
        }
        return createToken(user);
    }

    /**
     * 根据user信息生成Token
     *
     * @param user 用户信息
     * @return AccountToken
     */
    @Override
    public AccountToken createToken(UserEntity user) {
        String accessToken = JwtUtil.sign(user.getTel(), user.getPassword(), AccountToken.EXPIRE_TIME);
        String refreshToken = JwtUtil.sign(user.getTel(), user.getPassword(), AccountToken.REFRESH_EXPIRE_TIME);
        return new AccountToken(accessToken, refreshToken);
    }

}
