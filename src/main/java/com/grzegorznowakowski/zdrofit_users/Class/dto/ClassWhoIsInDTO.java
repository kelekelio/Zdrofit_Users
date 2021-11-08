package com.grzegorznowakowski.zdrofit_users.Class.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor
public class ClassWhoIsInDTO {
    private Long id;

    private String firstName;

    private String nickName;

    private String lastName;

    private String photoUrl;

    private boolean isStandby;

    private boolean isCanceled;

    private Long classId;

    private Long companyId;

    private Timestamp timestamp;

    private boolean isDeleted;

    public ClassWhoIsInDTO(@JsonProperty("id") Long id,
                      @JsonProperty("firstName") String firstName,
                      @JsonProperty("nickName") String nickName,
                      @JsonProperty("lastName") String lastName,
                      @JsonProperty("photoUrl") String photoUrl,
                      @JsonProperty("isStandby") boolean isStandby,
                      @JsonProperty("isCanceled") boolean isCanceled,
                      @JsonProperty("classId") Long classId,
                      @JsonProperty("companyId") Long companyId,
                      @JsonProperty("timestamp") Timestamp timestamp,
                      @JsonProperty("isDeleted") boolean isDeleted) {
        this.id = id;
        this.firstName = firstName;
        this.nickName = nickName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
        this.isStandby = isStandby;
        this.isCanceled = isCanceled;
        this.classId = classId;
        this.companyId = companyId;
        this.timestamp = timestamp;
        this.isDeleted = isDeleted;
    }
}
