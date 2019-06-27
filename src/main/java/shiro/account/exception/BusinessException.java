package shiro.account.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import shiro.account.result.ResultType;

/**
 * 业务异常
 *
 * @author hejq
 * @date 2019/6/27 10:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String message;

    private int code = ResultType.ERROR.code;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public BusinessException(int code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
