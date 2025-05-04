package com.example.BootCampProject.service.concretes;

import com.example.BootCampProject.entity.Blacklist;
import com.example.BootCampProject.repository.BlacklistRepository;
import com.example.BootCampProject.service.abstracts.BlacklistService;
import com.example.BootCampProject.service.dtos.requests.blackList.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.responses.blackList.GetBlacklistResponse;
import com.example.BootCampProject.service.mappers.BlacklistMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlacklistServiceImpl implements BlacklistService {
    private final BlacklistRepository blacklistRepository;
    private final BlacklistMapper blacklistMapper;

    public BlacklistServiceImpl(BlacklistRepository blacklistRepository, BlacklistMapper blacklistMapper) {
        this.blacklistRepository = blacklistRepository;
        this.blacklistMapper = blacklistMapper;
    }

    @Override
    public GetBlacklistResponse createBlacklist(CreateBlacklistRequest request) {
        Blacklist blacklist = blacklistMapper.createBlacklistRequestToBlacklist(request);
        Blacklist savedBlacklist = blacklistRepository.save(blacklist);
        return blacklistMapper.blacklistToGetBlacklistResponse(savedBlacklist);
    }

    @Override
    public GetBlacklistResponse getBlacklistById(Long id) {
        Blacklist blacklist = blacklistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blacklist not found"));
        return blacklistMapper.blacklistToGetBlacklistResponse(blacklist);
    }

    @Override
    public List<GetBlacklistResponse> getAllBlacklists() {
        return blacklistRepository.findAll().stream()
                .map(blacklistMapper::blacklistToGetBlacklistResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetBlacklistResponse updateBlacklist(Long id, CreateBlacklistRequest request) {
        Blacklist blacklist = blacklistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blacklist not found"));

        blacklist.setReason(request.getReason());
        blacklist.setDate(request.getDate());
        blacklist.setApplicantId(request.getApplicantId());

        Blacklist updatedBlacklist = blacklistRepository.save(blacklist);
        return blacklistMapper.blacklistToGetBlacklistResponse(updatedBlacklist);
    }

    @Override
    public void deleteBlacklist(Long id) {
        blacklistRepository.deleteById(id);
    }
}
