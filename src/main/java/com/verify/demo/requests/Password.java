package com.verify.demo.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Password {
    @JsonProperty
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
