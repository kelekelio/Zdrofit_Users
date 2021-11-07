package com.grzegorznowakowski.zdrofit_users.service;

import com.grzegorznowakowski.zdrofit_users.config.ZdrofitAPI;
import com.grzegorznowakowski.zdrofit_users.dto.WhoIsInCountDTO;
import com.grzegorznowakowski.zdrofit_users.dto.WhoIsInCountResponse;
import com.grzegorznowakowski.zdrofit_users.entity.WhoIsInCount;
import com.grzegorznowakowski.zdrofit_users.repository.WhoIsInCountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class WhoIsInCountService {

    private final RestTemplate restTemplate;
    private final WhoIsInCountRepository whoIsInCountRepository;
    private final ZdrofitAPI zdrofitAPI;
    private final static String WHO_IS_IN_COUNT_URL = "/v1/Clubs/WhoIsInCount";

    public List<WhoIsInCount> getAll() {
        return whoIsInCountRepository.findAll();
    }

    public void logZdrofitMembers() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", zdrofitAPI.getKey());

        UriComponents uri = UriComponentsBuilder.fromUriString(zdrofitAPI.getUrl())
                .path(WHO_IS_IN_COUNT_URL)
                .build().encode();

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<WhoIsInCountResponse> response = restTemplate.exchange(uri.toString(),
                HttpMethod.GET,
                entity,
                WhoIsInCountResponse.class);

        validateError(response);
        saveWhoIsInCount(response);
    }

    private void validateError(ResponseEntity<?> response) {
        if (response.getStatusCode().isError()) {
            throw new RuntimeException("API returned an error: " + response.getStatusCode());
        }
    }

    private void saveWhoIsInCount(ResponseEntity<WhoIsInCountResponse> response) {
        LocalDateTime time = LocalDateTime.now();
        Objects.requireNonNull(response.getBody()).getData().forEach(whoIsInCount -> logWhoIsIn(time, whoIsInCount));
    }

    private void logWhoIsIn(LocalDateTime time, WhoIsInCountDTO whoIsInCount) {
        WhoIsInCount logWhoIsIn = WhoIsInCount.builder()
                .clubId(whoIsInCount.getClubId())
                .count(whoIsInCount.getCount())
                .date(time)
                .build();
        System.out.println(logWhoIsIn.getClubId() + " => " + whoIsInCount.getCount());

        whoIsInCountRepository.save(logWhoIsIn);
    }
}
