package com.example.BootCampProject.service.dtos.requests.application;

public class CreateApplicationRequest {
    private Long applicantId;
    private Long bootcampId;

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
}
