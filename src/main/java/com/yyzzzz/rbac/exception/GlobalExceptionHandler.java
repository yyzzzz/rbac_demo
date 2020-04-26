package com.yyzzzz.rbac.exception;

import com.yyzzzz.rbac.common.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolationException;

/**
 * @author yyzzzz
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 默认统一异常处理方法
     * @ExceptionHandler 注解用来配置需要拦截的异常类型, 也可以是自定义异常
     */
    @ExceptionHandler(Exception.class)
    // 此处可以指定返回的状态码 和 返回 结果说明
    // @ResponseStatus(reason = "exception",value = HttpStatus.BAD_REQUEST)
    public ResultVo runtimeExceptionHandler(Exception e) {
        // 打印异常信息到控制台
        e.printStackTrace();
        log.error("请求出现异常,异常信息为: {}", e.getMessage());
        // 使用公共的结果类封装返回结果, 这里我指定状态码为 400
        return ResultVo.errorMsg(e.getMessage());
    }

    // 被@RequestBody和@RequestParam注解的请求实体，  post请求参数校验抛出的异常 ??
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return ResultVo.errorMsg(fieldError.getDefaultMessage());
    }

    //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult  || get请求参数校验抛出的异常 ??
    @ExceptionHandler(BindException.class)
    public ResultVo handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return ResultVo.errorMsg(fieldError.getDefaultMessage());
    }

    // form ??
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVo constraintViolationExceptionHandler(ConstraintViolationException e){
        //获取异常中第一个错误信息
        String message = e.getConstraintViolations().iterator().next().getMessage();
        return ResultVo.errorMsg(message);
    }

    // 文件超出范围异常
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResultVo maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e){
        //获取异常中第一个错误信息
        return ResultVo.errorMsg("图片超过500KB, 请压缩后重试！");
    }
}