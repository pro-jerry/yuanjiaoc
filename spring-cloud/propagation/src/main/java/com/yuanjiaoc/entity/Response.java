package com.yuanjiaoc.entity;

import lombok.Data;

@Data
public class Response {

    private int code;

    private String msg;

    private Object data;

    public Response() {
        super();
    }

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response success(Object data) {
        Response item = new Response(200, "success", data);
        return item;
    }
}
