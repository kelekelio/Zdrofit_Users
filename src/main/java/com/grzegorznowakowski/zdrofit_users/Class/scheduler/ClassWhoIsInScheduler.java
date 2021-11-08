package com.grzegorznowakowski.zdrofit_users.Class.scheduler;

import com.grzegorznowakowski.zdrofit_users.Class.service.ClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassWhoIsInScheduler {
    private final ClassService classService;

    @Value("${schedule.class-who-is-in.enable}")
    private boolean isEnabled;

    //todo: change cron to once a day schedule.download-once-a-day.cron
    @Scheduled(cron = "${schedule.download-every-30-min.cron}")
    public void logClassWhoIsInData() {
        if (isEnabled) {
            log.info("Logging members registered for classes at {}", LocalDateTime.now());
            long startTime = System.nanoTime();
            classService.logClassWhoIsIn();
            long importTimeInMs = (System.nanoTime() - startTime) / 1000000;
            log.info("Download done after: {} ms", importTimeInMs);

        } else {
            log.info("logClassWhoIsInData is disabled.");
        }
    }
}
