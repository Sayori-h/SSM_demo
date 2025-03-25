package com.powernode.Exception;

import com.powernode.result.CodeEnum;
import com.powernode.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        return R.FAIL(CodeEnum.FAIL,e.getMessage());
    }

    // 新增参数校验异常处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleValidationException(MethodArgumentNotValidException ex) {
        // 获取所有字段校验错误
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        // 收集所有错误信息
        List<String> errors = fieldErrors.stream()
                .map(error -> String.format("[%s] %s", error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        log.warn("参数校验异常：{}", errors);

        // 构建错误响应（包含所有错误信息）
        return R.FAIL(CodeEnum.INVALID_PARAM, "参数校验失败").putData("errors", errors);
    }
}
