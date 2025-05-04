package com.example.BootCampProject.service.abstracts;

import com.example.BootCampProject.service.dtos.requests.application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.responses.application.GetApplicationResponse;

import java.util.List;

public interface ApplicationService {
    GetApplicationResponse createApplication(CreateApplicationRequest request);
    GetApplicationResponse getApplicationById(Long id);
    List<GetApplicationResponse> getAllApplications();
    GetApplicationResponse updateApplication(Long id, CreateApplicationRequest request);
    void deleteApplication(Long id);
}
