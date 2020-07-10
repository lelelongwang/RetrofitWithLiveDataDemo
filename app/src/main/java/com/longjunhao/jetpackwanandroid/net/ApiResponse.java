package com.longjunhao.jetpackwanandroid.net;

/**
 * .ApiResponse
 *
 * @author Admitor
 * @date 2020/07/06
 */
public class ApiResponse<T> {
    
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR = 1;
    
    public int code; //状态码
    public String msg; //信息
    public T data; //数据
    
    public ApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    
    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
