package com.example.BootCampProject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "blacklists")
public class Blacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    private LocalDate date = LocalDate.now();

    @Column(name = "applicant_id")
    private Long applicantId;

    public Blacklist() {
    }

    public Blacklist(Long id, String reason, LocalDate date, Long applicantId) {
        this.id = id;
        this.reason = reason;
        this.date = date;
        this.applicantId = applicantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}
