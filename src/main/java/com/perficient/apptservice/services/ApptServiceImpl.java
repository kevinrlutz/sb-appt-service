package com.perficient.apptservice.services;

import com.perficient.apptservice.repositories.ApptRepository;
import com.perficient.apptservice.web.model.ApptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by RA on 06-30-2022.
 */

@Service
public class ApptServiceImpl implements ApptService {

    @Autowired
    private ApptRepository apptRepository;

    // Save operation
    @Override
    public ApptDto saveAppt(ApptDto Appt) {
        return apptRepository.save(Appt);
    }

    // Read Operation
    @Override
    public List<ApptDto> fetchApptList() {
        return apptRepository.findAll();
    }

    // Update Operation
    @Override
    public ApptDto updateAppt(ApptDto Apt, UUID id) {
        // TODO: Implement
        return null;
    }

    // Delete operation
    @Override
    public void deleteApptById(UUID id) {
        apptRepository.deleteById(id);
    }


}
