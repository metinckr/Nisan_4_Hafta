package com.example.BootCampProject.service.dtos.responses.bootCamp;

import com.example.BootCampProject.entity.BootcampState;

import java.time.LocalDate;

public class GetBootcampResponse {
    private Long id;
    private String name;
    private Long instructorId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BootcampState bootcampState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BootcampState getBootcampState() {
        return bootcampState;
    }

    public void setBootcampState(BootcampState bootcampState) {
        this.bootcampState = bootcampState;
    }
}
