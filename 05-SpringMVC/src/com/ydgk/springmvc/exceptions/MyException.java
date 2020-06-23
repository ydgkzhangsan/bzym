package com.ydgk.springmvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-23 16:46
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "就是不知道为什么想抛出一个异常")
public class MyException extends RuntimeException {

    static final long serialVersionUID = -70348912347190745L;
}
