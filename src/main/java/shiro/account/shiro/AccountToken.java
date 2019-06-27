package shiro.account.shiro;

import com.google.gson.Gson;
import lombok.Data;

/**
 * 账户token
 *
 * @author hejq
 * @date 2019/6/27 13:51
 */
@Data
public class AccountToken {
    /**
     * 访问过期时间30分钟
     */
    public static final long EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 访问标识
     */
    public static final String EXPIRE_KEY = "accessToken";

    /**
     * refreshToken 过期时间7天
     */
    public static final long REFRESH_EXPIRE_TIME = 7 * 24 * 60 *60 * 1000;

    /**
     * 访问标识
     */
    public static final String REFRESH_EXPIRE_KEY = "refreshToken";

    /**
     * 账户key
     */
    public static final String ACCOUNT_KEY = "userName";

    /**
     * 访问token
     */
    private String accessToken;

    /**
     * 刷新token
     */
    private String refreshToken;

    public AccountToken() {}

    public AccountToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
