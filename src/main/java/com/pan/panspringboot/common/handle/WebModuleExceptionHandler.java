package com.pan.panspringboot.common.handle;

import com.pan.panspringboot.common.exception.GeneralException;
import com.pan.panspringboot.common.result.ResultBean;
import com.pan.panspringboot.common.result.ResultEnum;
import com.pan.panspringboot.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@ControllerAdvice
public class WebModuleExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(WebModuleExceptionHandler.class);

    //自定义异常处理
    @ExceptionHandler(value = GeneralException.class)
    @ResponseBody
    public ResultBean<?> handleGeneralException(GeneralException generalException) {
        logger.error("The generalException occurred",generalException);
        return ResultUtil.error(generalException.getresultEnum().getCode(), generalException.getresultEnum().getMessage());
    }


    //其他异常处理
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean<?> handleException(Exception exception) {
        logger.error("The exception occurred",exception);
        return ResultUtil.error(ResultEnum.OPERATION_FAILED.getCode(), ResultEnum.OPERATION_FAILED.getMessage());
    }


    /*//404异常处理
    @ExceptionHandler(value = NoSuchRequestHandlingMethodException.class)
    @ResponseBody
    public ResultBean<?> handle404Exception(NoSuchRequestHandlingMethodException exception) {
        logger.error("The exception occurred",exception);
        return ResultUtil.error(ResultEnum.OPERATION_FAILED.getCode(), ResultEnum.OPERATION_FAILED.getMessage());
    }
*/

}
