package com.grzegorznowakowski.zdrofit_users.controller;

import com.grzegorznowakowski.zdrofit_users.entity.WhoIsInCount;
import com.grzegorznowakowski.zdrofit_users.service.WhoIsInCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/WhoIsInCount")
public class WhoIsInCountController {

    private final WhoIsInCountService whoIsInCountService;

    @GetMapping("/all")
    public List<WhoIsInCount> getAllSaved() {
        return whoIsInCountService.getAll();
    }
}
