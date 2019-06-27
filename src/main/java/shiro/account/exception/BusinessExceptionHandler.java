package shiro.account.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shiro.account.result.ResultBean;

/**
 * 捕获业务操作异常
 *
 * @author hejq
 * @date 2019/6/27 11:27
 */
@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResultBean handleBusinessException(BusinessException e) {
        return ResultBean.error(e.getMessage());
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(Exception.class)
    public ResultBean handleException(Exception e) {
        return ResultBean.error(e.getMessage());
    }
}
