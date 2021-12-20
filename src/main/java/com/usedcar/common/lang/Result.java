package com.usedcar.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kunlong Wang
 * @create 2021-11-21 17:36
 */
@Data
public class Result implements Serializable {
    private int code; // OK: 200
    private String msg;
    private Object data;

    public static Result succ(Object data) {
        return succ(200, "operate successfully", data);
    }
    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static Result fail(String msg) {
        return fail(400, msg, null);
    }
    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }
    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
