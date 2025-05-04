package com.example.BootCampProject.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicant_id")
    private Long applicantId;

    @Column(name = "bootcamp_id")
    private Long bootcampId;

    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    public Application() {
    }

    public Application(Long id, Long applicantId, Long bootcampId, ApplicationState applicationState, LocalDateTime createdDate) {
        this.id = id;
        this.applicantId = applicantId;
        this.bootcampId = bootcampId;
        this.applicationState = applicationState;
        this.createdDate = createdDate;
    }

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
