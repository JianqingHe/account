package shiro.account.result;

/**
 * 返回状态
 *
 * @author hejq
 * @date 2019/6/27 10:32
 */
public enum  ResultType {

    /**
     * 成功
     */
    SUCCESS(0, "success"),

    /**
     * 失败
     */
    ERROR(500, "error");

    /**
     * 状态码
     */
    public int code;

    /**
     * 提示信息
     */
    public String message;

    ResultType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
