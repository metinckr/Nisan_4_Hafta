package com.example.BootCampProject.service.concretes;

import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.repository.BootcampRepository;
import com.example.BootCampProject.service.abstracts.BootcampService;
import com.example.BootCampProject.service.dtos.requests.bootCamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.bootCamp.GetBootcampResponse;
import com.example.BootCampProject.service.mappers.BootcampMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BootcampServiceImpl implements BootcampService {
    private final BootcampRepository bootcampRepository;
    private final BootcampMapper bootcampMapper;

    public BootcampServiceImpl(BootcampRepository bootcampRepository, BootcampMapper bootcampMapper) {
        this.bootcampRepository = bootcampRepository;
        this.bootcampMapper = bootcampMapper;
    }

    @Override
    public GetBootcampResponse createBootcamp(CreateBootcampRequest request) {
        Bootcamp bootcamp = bootcampMapper.createBootcampRequestToBootcamp(request);
        Bootcamp savedBootcamp = bootcampRepository.save(bootcamp);
        return bootcampMapper.bootcampToGetBootcampResponse(savedBootcamp);
    }

    @Override
    public GetBootcampResponse getBootcampById(Long id) {
        Bootcamp bootcamp = bootcampRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bootcamp not found"));
        return bootcampMapper.bootcampToGetBootcampResponse(bootcamp);
    }

    @Override
    public List<GetBootcampResponse> getAllBootcamps() {
        return bootcampRepository.findAll().stream()
                .map(bootcampMapper::bootcampToGetBootcampResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetBootcampResponse updateBootcamp(Long id, CreateBootcampRequest request) {
        Bootcamp bootcamp = bootcampRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bootcamp not found"));

        bootcamp.setName(request.getName());
        bootcamp.setInstructorId(request.getInstructorId());
        bootcamp.setStartDate(request.getStartDate());
        bootcamp.setEndDate(request.getEndDate());

        Bootcamp updatedBootcamp = bootcampRepository.save(bootcamp);
        return bootcampMapper.bootcampToGetBootcampResponse(updatedBootcamp);
    }

    @Override
    public void deleteBootcamp(Long id) {
        bootcampRepository.deleteById(id);
    }
}
