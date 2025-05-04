package com.example.BootCampProject.service.abstracts;

import com.example.BootCampProject.service.dtos.requests.bootCamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.bootCamp.GetBootcampResponse;

import java.util.List;

public interface BootcampService {
    GetBootcampResponse createBootcamp(CreateBootcampRequest request);
    GetBootcampResponse getBootcampById(Long id);
    List<GetBootcampResponse> getAllBootcamps();
    GetBootcampResponse updateBootcamp(Long id, CreateBootcampRequest request);
    void deleteBootcamp(Long id);
}
