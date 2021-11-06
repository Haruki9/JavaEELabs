package com.haruki.lab4.util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: haruki9
 * Email: a784812609@qq.com
 * Date: 2021/10/20
 * Time: 20:18
 * Description：
 */
@Data
@NoArgsConstructor
public class ReturnObject {
    private ResponseCode code;

    private String message;

    private Object data;

    public ReturnObject(ResponseCode code,Object object){
        this.code=code;
        this.message=code.getMessage();
        this.data=object;
    }

    public ReturnObject(ResponseCode code){
        this.code=code;
        this.message=code.getMessage();
        this.data=null;
    }

    public ReturnObject(ResponseCode code,String message,Object object){
        this.code=code;
        this.message=message;
        this.data=object;
    }
}
