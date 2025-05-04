package com.example.BootCampProject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bootcamps")
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "instructor_id")
    private Long instructorId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private BootcampState bootcampState = BootcampState.PREPARING;

    public Bootcamp() {
    }

    public Bootcamp(Long id, String name, Long instructorId, LocalDate startDate, LocalDate endDate, BootcampState bootcampState) {
        this.id = id;
        this.name = name;
        this.instructorId = instructorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bootcampState = bootcampState;
    }

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
