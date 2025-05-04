package com.example.BootCampProject.service.abstracts;

import com.example.BootCampProject.service.dtos.requests.blackList.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.responses.blackList.GetBlacklistResponse;

import java.util.List;

public interface BlacklistService {
    GetBlacklistResponse createBlacklist(CreateBlacklistRequest request);
    GetBlacklistResponse getBlacklistById(Long id);
    List<GetBlacklistResponse> getAllBlacklists();
    GetBlacklistResponse updateBlacklist(Long id, CreateBlacklistRequest request);
    void deleteBlacklist(Long id);
}
