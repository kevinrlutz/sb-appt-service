package com.perficient.apptservice.services;

import com.perficient.apptservice.web.model.ApptDto;

import java.util.List;

/**
 * Created by RA on 06-30-2022.
 */

public interface ApptService {

    // Save operation
    ApptDto saveAppt(ApptDto Appt);

    // Read Operation (Single)
    ApptDto getApptById(String id);

    // Read Operation (Multiple)
    List<ApptDto> getApptList();

    // Update Operation
    ApptDto updateAppt(ApptDto Apt, String id);

    // Delete operation
    void deleteApptById(String id);

    List<ApptDto> getAllApptsByName(String name);

    List<ApptDto> getApptListByUserId(String userId);
}
