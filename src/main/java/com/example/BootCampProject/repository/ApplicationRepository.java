package com.example.BootCampProject.repository;

import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.entity.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findByApplicantId(Long applicantId);
    List<Application> findByBootcampId(Long bootcampId);
    List<Application> findByApplicationState(ApplicationState state);
}
