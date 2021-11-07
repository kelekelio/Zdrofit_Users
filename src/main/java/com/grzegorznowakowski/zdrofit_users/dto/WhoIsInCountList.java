package com.grzegorznowakowski.zdrofit_users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class WhoIsInCountList {

    private Integer count;
    private Long clubId;

    public WhoIsInCountList(@JsonProperty("count") Integer count,
                            @JsonProperty("clubId") Long clubId) {
        this.count = count;
        this.clubId = clubId;
    }

}
