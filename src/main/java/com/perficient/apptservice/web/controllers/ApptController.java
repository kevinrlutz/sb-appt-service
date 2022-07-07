package com.perficient.apptservice.web.controllers;

import com.perficient.apptservice.services.ApptService;
import com.perficient.apptservice.web.model.ApptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by RA on 07-05-2022.
 */

@RestController
public class ApptController {

    @Autowired
    private ApptService apptService;

    // Save operation
    @PostMapping("/appointments")
    public ApptDto saveAppt(@RequestBody ApptDto apptDto) {
        return apptService.saveAppt(apptDto);
    }

    // Read operation
    @GetMapping("/appointments")
    public List<ApptDto> fetchApptList() {
        return apptService.fetchApptList();
    }

    // Update operation
    @PutMapping("/appointments/{id}")
    public ApptDto updateAppt(@RequestBody ApptDto apptDto, @PathVariable("id") UUID id) {
        return apptService.updateAppt(apptDto, id);
    }

    // Delete operation
    @DeleteMapping("/appointments/{id}")
    public String deleteApptById(@PathVariable("id") UUID id) {
        apptService.deleteApptById(id);
        return "Deleted Successfully!";
    }
}
