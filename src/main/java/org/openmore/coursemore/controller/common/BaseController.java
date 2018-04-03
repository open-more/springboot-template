package org.openmore.coursemore.controller.common;

import org.openmore.coursemore.dto.common.ErrorResponseEntity;
import org.slf4j.Logger;
import org.openmore.common.exception.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by michael on 2017/6/16.
 */
@RestController
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected HttpServletRequest request = null;

    @ExceptionHandler
    public ResponseEntity handlerException(HttpServletRequest request, Exception ex) {
        if (ex instanceof InvalidParamsException) {
            InvalidParamsException exception = (InvalidParamsException) ex;
            return ErrorResponseEntity.buildToResponseEntity(-1, exception.getMsg());
        } else if (ex instanceof InvalidTokenException) {
            InvalidTokenException exception = (InvalidTokenException) ex;
            return ErrorResponseEntity.buildToResponseEntity(HttpStatus.UNAUTHORIZED, -1, exception.getMsg());
        } else {
            return ErrorResponseEntity.buildToResponseEntity(-1, "请求失败");
        }
    }
}
