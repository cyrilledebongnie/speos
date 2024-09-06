package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ErrorDTO implements InterfaceDTO {

    private int code;
    private String message;

    public ErrorDTO() {

    }

    public ErrorDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
