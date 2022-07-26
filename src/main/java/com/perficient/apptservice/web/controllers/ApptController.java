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

@RestController
@RequiredArgsConstructor
public class ApptController {

    @Autowired
    private final ApptService apptService;

    // Save operation
    @PostMapping("/appointments")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ApptDto saveAppt(@RequestBody ApptDto apptDto) {
        return apptService.saveAppt(apptDto);
    }

    @GetMapping("/appointments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApptDto getApptById(@PathVariable("id") String id) {
        return apptService.getApptById(id);
    }

    // Read operation
    @GetMapping("/appointments")
    @ResponseStatus(HttpStatus.OK)
    public List<ApptDto> getApptList() {
        return apptService.getApptList();
    }

    @GetMapping("/{userId}/appointments")
    @ResponseStatus(HttpStatus.OK)
    public List<ApptDto> getApptListByUserId(@PathVariable("userId") String userId) {
        return apptService.getApptListByUserId(userId);
    }

    // Search operation
    @GetMapping("/appointments/search/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ApptDto> getAllApptsByName(@PathVariable("name") String name) {
        System.out.println("In getallappts controller method in appt service");
        return apptService.getAllApptsByName(name);
    }

    // Update operation
    @PutMapping("/appointments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApptDto updateAppt(@RequestBody ApptDto apptDto, @PathVariable("id") String id) {
        return apptService.updateAppt(apptDto, id);
    }

    // Delete operation
    @DeleteMapping("/appointments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteApptById(@PathVariable("id") String id) {
        apptService.deleteApptById(id);
        return id;
    }

}
