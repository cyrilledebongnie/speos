package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDTO<T> {
    private T result;
    private ErrorDTO error;
    
    public ResponseDTO() {
        this.result = null;
        this.error = null;
    }

    public ResponseDTO(T result) {
        this.result = result;
        this.error = null;
    }

    public ResponseDTO( ErrorDTO error) {
        this.error = error;
        this.result = null;
    }
}