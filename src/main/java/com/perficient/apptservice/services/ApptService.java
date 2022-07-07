package com.perficient.apptservice.services;

import com.perficient.apptservice.web.model.ApptDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by RA on 06-30-2022.
 */

public interface ApptService {

    // Save operation
    ApptDto saveAppt(ApptDto Appt);

    // Read Operation
    List<ApptDto> fetchApptList();

    // Update Operation
    ApptDto updateAppt(ApptDto Apt, UUID id);

    // Delete operation
    void deleteApptById(UUID id);
}
