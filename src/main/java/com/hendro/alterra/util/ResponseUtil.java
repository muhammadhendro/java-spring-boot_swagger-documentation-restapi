package com.hendro.alterra.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    private ResponseUtil(){}

    public static ResponseEntity<Object> build(Object data, String code, HttpStatus httpStatus) {
        Map<String, Object> map = new HashMap<>();

        map.put("timestamp", new Date());
        map.put("response_code", httpStatus.value());
        map.put("message", code);
        map.put("data", data);

        return new ResponseEntity<>(map, httpStatus);
    }
}
