package com.grzegorznowakowski.zdrofit_users.service;

import com.grzegorznowakowski.zdrofit_users.entity.WhoIsInCount;
import com.grzegorznowakowski.zdrofit_users.repository.WhoIsInCountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WhoIsInCountService {

    private final WhoIsInCountRepository whoIsInCountRepository;

    public List<WhoIsInCount> getAll() {
        return whoIsInCountRepository.findAll();
    }
}
