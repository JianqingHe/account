package shiro.account.utils;

/**
 * @author hejq
 * @date 2019/6/27 10:42
 */
public class StringUtils extends org.springframework.util.StringUtils {

    /**
     * * 判断一个对象是否非空
     *
     * @param data Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object data) {
        return !isNull(data);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * 不为空
     *
     * @param value 值
     * @return
     */
    public static boolean isNotBlank(String value) {
        return isNotBlank(value);
    }

    /**
     * 不为空
     *
     * @param value 值
     * @return
     */
    public static boolean isBlank(String value) {
        return isBlank(value);
    }
}
