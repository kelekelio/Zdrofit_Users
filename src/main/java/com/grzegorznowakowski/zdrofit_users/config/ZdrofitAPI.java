package com.grzegorznowakowski.zdrofit_users.config;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
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
}
