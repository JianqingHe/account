package shiro.account.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import shiro.account.utils.StringUtils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 封装返回结果
 *
 * @author hejq
 * @date 2019/6/27 10:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ResultBean extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String msg;

    /**
     * 数据对象
     */
    private Object data;


    /**
     * 初始化一个新创建的 ResultBean 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResultBean(ResultType type, String msg, Object data) {
        super.put(CODE_TAG, type.code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 初始化一个新创建的 ResultBean 对象
     *
     * @param code 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResultBean(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResultBean success() {
        return success(ResultType.SUCCESS.message);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResultBean success(String msg) {
        return ResultBean.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResultBean success(String msg, Object data) {
        return new ResultBean(ResultType.SUCCESS, msg, data);
    }

    /**
     * 添加数据
     *
     * @param object
     * @return
     */
    public ResultBean putObject(Object object) {
        ResultBean resultBean = success();
        resultBean.put(DATA_TAG, object);
        return resultBean;
    }

    /**
     * 返回失败消息
     *
     * @return 失败消息
     */
    public static ResultBean error() {
        return error(ResultType.ERROR.message);
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @return 失败消息
     */
    public static ResultBean error(String msg) {
        return ResultBean.error(msg, null);
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 失败消息
     */
    public static ResultBean error(String msg, Object data) {
        return new ResultBean(ResultType.ERROR, msg, data);
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @param msg 数据对象
     * @return 失败消息
     */
    public static ResultBean error(int code, String msg) {
        return new ResultBean(code, msg, null);
    }

}
