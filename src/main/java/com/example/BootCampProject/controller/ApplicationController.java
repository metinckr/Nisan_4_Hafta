package com.example.BootCampProject.controller;

import com.example.BootCampProject.service.abstracts.ApplicationService;
import com.example.BootCampProject.service.dtos.requests.application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.responses.application.GetApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<GetApplicationResponse> createApplication(@RequestBody CreateApplicationRequest request) {
        return new ResponseEntity<>(applicationService.createApplication(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetApplicationResponse> getApplicationById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @GetMapping
    public ResponseEntity<List<GetApplicationResponse>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetApplicationResponse> updateApplication(
            @PathVariable Long id,
            @RequestBody CreateApplicationRequest request) {
        return ResponseEntity.ok(applicationService.updateApplication(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    public ApplicationService getApplicationService() {
        return applicationService;
    }

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
}
