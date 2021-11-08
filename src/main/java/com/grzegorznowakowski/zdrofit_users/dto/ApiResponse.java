package com.grzegorznowakowski.zdrofit_users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiResponse {

    private String errors;

    public ApiResponse(@JsonProperty("errors") String errors) {
        this.errors = errors;
    }
}
