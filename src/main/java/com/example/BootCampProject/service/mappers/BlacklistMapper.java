package com.example.BootCampProject.service.mappers;

import com.example.BootCampProject.entity.Blacklist;
import com.example.BootCampProject.service.dtos.requests.blackList.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.responses.blackList.GetBlacklistResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlacklistMapper {
    @Mapping(target = "id", ignore = true)
    Blacklist createBlacklistRequestToBlacklist(CreateBlacklistRequest request);

    GetBlacklistResponse blacklistToGetBlacklistResponse(Blacklist blacklist);
}
