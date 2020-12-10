package com.experiencers.playeasy.model.entity;

public class ApplyResponse {
    private String name;
    private String message;
    private String stack;

    public ApplyResponse(){

    }

    public ApplyResponse(String name, String message, String stack) {
        this.name = name;
        this.message = message;
        this.stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
