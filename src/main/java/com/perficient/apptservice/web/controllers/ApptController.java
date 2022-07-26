package com.perficient.apptservice.web.controllers;

import com.perficient.apptservice.services.ApptService;
import com.perficient.apptservice.web.model.ApptDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by RA on 07-05-2022.
 */

@RequestMapping("/appointments")
@RestController
@RequiredArgsConstructor
public class ApptController {

    @Autowired
    private final ApptService apptService;

    // Save operation
    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ApptDto saveAppt(@RequestBody ApptDto apptDto) {
        return apptService.saveAppt(apptDto);
    }

    // Read operation
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ApptDto getApptById(@PathVariable("id") String id) {
        return apptService.getApptById(id);
    }

    // Read operation
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ApptDto> getApptList() {
        return apptService.getApptList();
    }

    // Read operation
    @GetMapping("/user/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ApptDto> getApptListByUserId(@PathVariable("userId") String userId) {
        return apptService.getApptListByUserId(userId);
    }

    // Search operation
    @GetMapping("/search/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ApptDto> getAllApptsByName(@PathVariable("name") String name) {
        return apptService.getAllApptsByName(name);
    }

    // Update operation

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ApptDto updateAppt(@RequestBody ApptDto apptDto, @PathVariable("id") String id) {
        return apptService.updateAppt(apptDto, id);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String deleteApptById(@PathVariable("id") String id) {
        apptService.deleteApptById(id);
        return id;
    }

}
