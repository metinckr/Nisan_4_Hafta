package com.example.BootCampProject.service.dtos.responses.application;

import com.example.BootCampProject.entity.ApplicationState;

public class GetApplicationResponse {
    private Long id;
    private Long applicantId;
    private Long bootcampId;
    private ApplicationState applicationState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getBootcampId() {
        return bootcampId;
    }

    public void setBootcampId(Long bootcampId) {
        this.bootcampId = bootcampId;
    }

    public ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}
