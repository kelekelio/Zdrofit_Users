package com.grzegorznowakowski.zdrofit_users.utils;

import org.springframework.http.ResponseEntity;

public class HttpUtils {

    public static void validateError(ResponseEntity<?> response) {
        if (response.getStatusCode().isError()) {
            throw new RuntimeException("API returned an error: " + response.getStatusCode());
        }
    }
}
