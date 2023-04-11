package com.pdev.rest.webservices.restfulwebservices.hello;

public class HelloWorld {
    private String msg;

    public HelloWorld(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
