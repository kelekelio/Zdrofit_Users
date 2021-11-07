package com.grzegorznowakowski.zdrofit_users.scheduler;

import com.grzegorznowakowski.zdrofit_users.service.WhoIsInCountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class WhoIsInCountScheduler {
    private final WhoIsInCountService whoIsInCountService;

    @Value("${schedule.download-who-is-in-count.enable}")
    private boolean isSchedulerEnabled;

    @Scheduled(cron = "${schedule.download-who-is-in-count.cron}")
    public void downloadWhoIsInCount() {
        if (isSchedulerEnabled) {
            log.info("Downloading current number of members in each club at {}", LocalDateTime.now());

            long startTime = System.nanoTime();

            long importTimeInMs = (System.nanoTime() - startTime) / 1000000;
            log.info("Download done after: {} ms", importTimeInMs);
        } else {
            log.info("WhoIsInCountScheduler is disabled.");
        }
    }
}
