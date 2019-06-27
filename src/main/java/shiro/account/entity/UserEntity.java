package shiro.account.entity;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 用户
 *
 * @author hejq
 * @date 2019/6/27 10:49
 */
@Data
@ConfigurationProperties(prefix = "login")
@Component
public class UserEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String tel;

    /**
     * 性别
     */
    private String sex;

    /**
     * 账户
     */
    private String account;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
