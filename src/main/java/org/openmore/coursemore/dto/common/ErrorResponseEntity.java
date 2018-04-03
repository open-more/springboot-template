package org.openmore.coursemore.dto.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by MichaelTang on 2017/6/16.
 */
@ApiModel(description = "服务器响应ErrorResponseEntity,有返回msg和errorCode." +
        "<br>服务器端业务出错时，Http statuscode = 400 body返回ErrorResponseEntity." +
        "<br>如果服务器处理成功，Http statuscode = 200 body返回结果")
public class ErrorResponseEntity {
    /**
     * 自定义消息内容
     */
    @ApiModelProperty(value = "提示信息", required = true)
    public String msg;
    /**
     * 自定义错误码
     */
    @ApiModelProperty(value = "错误码", required = true)
    public int errorCode;


    public ErrorResponseEntity(int errorCode, String msg) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    /**
     * 返回400状态码给客户端，将{@link ErrorResponseEntity}对象的json数据发送给客户端
     *
     * @param errorCode 自定义错误码{@link ErrorResponseEntity#errorCode}
     * @param msg       消息内容 ,{@link ErrorResponseEntity#msg}
     * @return 400状态码的 {@link ResponseEntity}
     */
    public static ResponseEntity buildToResponseEntity(int errorCode, String msg) {
        ErrorResponseEntity responseEntity = new ErrorResponseEntity(errorCode, msg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseEntity);
    }

    /**
     * 返回400状态码给客户端，将{@link ErrorResponseEntity}对象的json数据发送给客户端
     *
     * @param statusCode Http状态码
     * @param errorCode  自定义错误码{@link ErrorResponseEntity#errorCode}
     * @param msg        消息内容 ,{@link ErrorResponseEntity#msg}
     * @return 400状态码的 {@link ResponseEntity}
     */
    public static ResponseEntity buildToResponseEntity(HttpStatus statusCode, int errorCode, String msg) {
        ErrorResponseEntity responseEntity = new ErrorResponseEntity(errorCode, msg);
        return ResponseEntity.status(statusCode).body(responseEntity);
    }
}
