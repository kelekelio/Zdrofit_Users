package com.grzegorznowakowski.zdrofit_users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
public class WhoIsInCountResponse {

    private String errors;
    private List<WhoIsInCountDTO> data;

    public WhoIsInCountResponse(@JsonProperty("errors") String errors,
                                @JsonProperty("data") List<WhoIsInCountDTO> data) {
        this.errors = errors;
        this.data = data;
    }
}
