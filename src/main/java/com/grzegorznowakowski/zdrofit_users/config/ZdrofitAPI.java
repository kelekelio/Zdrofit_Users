package com.grzegorznowakowski.zdrofit_users.config;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@Validated
@Configuration
@ConfigurationProperties(prefix = "zdrofit.api")
public class ZdrofitAPI {

    @NotNull
    private String url;

    @NotNull
    private String key;

    @NotNull
    private String format;

    public HttpEntity<?> getHttpEntity() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", key);
        return new HttpEntity<>(headers);
    }

}
