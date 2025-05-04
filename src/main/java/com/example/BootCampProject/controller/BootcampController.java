package com.example.BootCampProject.controller;

import com.example.BootCampProject.service.abstracts.BootcampService;
import com.example.BootCampProject.service.dtos.requests.bootCamp.CreateBootcampRequest;
import com.example.BootCampProject.service.dtos.responses.bootCamp.GetBootcampResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
public class BootcampController {
    private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @PostMapping
    public ResponseEntity<GetBootcampResponse> createBootcamp(@RequestBody CreateBootcampRequest request) {
        return new ResponseEntity<>(bootcampService.createBootcamp(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBootcampResponse> getBootcampById(@PathVariable Long id) {
        return ResponseEntity.ok(bootcampService.getBootcampById(id));
    }

    @GetMapping
    public ResponseEntity<List<GetBootcampResponse>> getAllBootcamps() {
        return ResponseEntity.ok(bootcampService.getAllBootcamps());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetBootcampResponse> updateBootcamp(
            @PathVariable Long id,
            @RequestBody CreateBootcampRequest request) {
        return ResponseEntity.ok(bootcampService.updateBootcamp(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBootcamp(@PathVariable Long id) {
        bootcampService.deleteBootcamp(id);
        return ResponseEntity.noContent().build();
    }
}
