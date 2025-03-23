package com.powernode.Exception;

import com.powernode.result.CodeEnum;
import com.powernode.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        return R.FAIL(CodeEnum.FAIL,e.getMessage());
    }
}
