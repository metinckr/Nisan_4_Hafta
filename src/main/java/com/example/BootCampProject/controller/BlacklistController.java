package com.example.BootCampProject.controller;

import com.example.BootCampProject.service.abstracts.BlacklistService;
import com.example.BootCampProject.service.dtos.requests.blackList.CreateBlacklistRequest;
import com.example.BootCampProject.service.dtos.responses.blackList.GetBlacklistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blacklists")
public class BlacklistController {
    private final BlacklistService blacklistService;

    @PostMapping
    public ResponseEntity<GetBlacklistResponse> createBlacklist(@RequestBody CreateBlacklistRequest request) {
        return new ResponseEntity<>(blacklistService.createBlacklist(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBlacklistResponse> getBlacklistById(@PathVariable Long id) {
        return ResponseEntity.ok(blacklistService.getBlacklistById(id));
    }

    @GetMapping
    public ResponseEntity<List<GetBlacklistResponse>> getAllBlacklists() {
        return ResponseEntity.ok(blacklistService.getAllBlacklists());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetBlacklistResponse> updateBlacklist(
            @PathVariable Long id,
            @RequestBody CreateBlacklistRequest request) {
        return ResponseEntity.ok(blacklistService.updateBlacklist(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlacklist(@PathVariable Long id) {
        blacklistService.deleteBlacklist(id);
        return ResponseEntity.noContent().build();
    }

    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }
}
