package shiro.account.shiro;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author hejq
 * @date 2019/6/27 13:49
 */
public class JwtUtil {
    /**
     * 校验token是否正确
     * @param token 密钥
     * @param secret 用户的密码
     * @param userName 账户key
     * @return 是否正确
     */
    public static boolean verify(String token, String userName, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(AccountToken.ACCOUNT_KEY, userName)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息
     * 无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(AccountToken.ACCOUNT_KEY).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param userName 账户key
     * @param secret 用户的密码
     * @param expireTime 过期时间
     * @return 加密的token
     */
    public static String sign(String userName, String secret, long expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim(AccountToken.ACCOUNT_KEY, userName)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }


}
