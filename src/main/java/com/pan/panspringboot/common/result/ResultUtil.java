package com.pan.panspringboot.common.result;


public class ResultUtil {

	public static <T> ResultBean<T> success(T bodyData) {
    	ResultBean<T> result = new ResultBean<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setBodyData(bodyData);
        return result;
    }

    public static <T> ResultBean<T> error(T bodyData) {
        ResultBean<T> result = new ResultBean<>();
        result.setCode(ResultEnum.OPERATION_FAILED.getCode());
        result.setMessage(ResultEnum.OPERATION_FAILED.getMessage());
        result.setBodyData(bodyData);
        return result;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> ResultBean<T> error(Integer code, String message) {
    	ResultBean result = new ResultBean();
        result.setCode(code);
        result.setMessage(message);
        result.setBodyData(null);
        return result;
    }

    @SuppressWarnings("rawtypes")
    public static ResultBean success() {
        return success(null);
    }

    @SuppressWarnings("rawtypes")
    public static ResultBean error() {
        return error(null);
    }

    public static <T> PageResultBean<T> pageSuccess(PageResultBean result) {
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());

        return result;
    }
}
