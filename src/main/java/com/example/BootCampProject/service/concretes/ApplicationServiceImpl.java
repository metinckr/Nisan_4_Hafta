package com.example.BootCampProject.service.concretes;

import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.repository.ApplicationRepository;
import com.example.BootCampProject.service.abstracts.ApplicationService;
import com.example.BootCampProject.service.dtos.requests.application.CreateApplicationRequest;
import com.example.BootCampProject.service.dtos.responses.application.GetApplicationResponse;
import com.example.BootCampProject.service.mappers.ApplicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    @Override
    public GetApplicationResponse createApplication(CreateApplicationRequest request) {
        Application application = applicationMapper.createApplicationRequestToApplication(request);
        Application savedApplication = applicationRepository.save(application);
        return applicationMapper.applicationToGetApplicationResponse(savedApplication);
    }

    @Override
    public GetApplicationResponse getApplicationById(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        return applicationMapper.applicationToGetApplicationResponse(application);
    }

    @Override
    public List<GetApplicationResponse> getAllApplications() {
        return applicationRepository.findAll().stream()
                .map(applicationMapper::applicationToGetApplicationResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetApplicationResponse updateApplication(Long id, CreateApplicationRequest request) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setApplicantId(request.getApplicantId());
        application.setBootcampId(request.getBootcampId());

        Application updatedApplication = applicationRepository.save(application);
        return applicationMapper.applicationToGetApplicationResponse(updatedApplication);
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, ApplicationMapper applicationMapper) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
    }

    public ApplicationRepository getApplicationRepository() {
        return applicationRepository;
    }

    public ApplicationMapper getApplicationMapper() {
        return applicationMapper;
    }

}
