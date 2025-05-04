package com.example.BootCampProject.service.mappers;

import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.service.dtos.requests.bootCamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.bootCamp.GetBootcampResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BootcampMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bootcampState", constant = "PREPARING")
    Bootcamp createBootcampRequestToBootcamp(CreateBootcampRequest request);

    GetBootcampResponse bootcampToGetBootcampResponse(Bootcamp bootcamp);
}
