package cz.itnetwork.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RunTimeExceptionAdvice {

    @ExceptionHandler({RuntimeException.class})
    public void handleRunTimeException(){}
}
