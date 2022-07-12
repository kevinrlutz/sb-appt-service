package com.perficient.apptservice.services;

import com.perficient.apptservice.repositories.ApptRepository;
import com.perficient.apptservice.web.model.ApptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Read Operation (Single)
    @Override
    public ApptDto getAppt(String id) {
        return apptRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    // Read Operation (Multiple)
    @Override
    public List<ApptDto> getApptList() {
        return apptRepository.findAll();
    }

    // Update Operation
    @Override
    public ApptDto updateAppt(ApptDto apptDto, String id) {
        ApptDto appt = apptRepository.findById(id).orElseThrow(RuntimeException::new);

        appt.setApptName(apptDto.getApptName());
        appt.setApptType(apptDto.getApptType());
        appt.setDescription(apptDto.getDescription());
        appt.setStartTime(apptDto.getStartTime());
        appt.setEndTime(apptDto.getEndTime());
        appt.setMetadata(apptDto.getMetadata());

        return apptRepository.save(appt);
    }

    // Delete operation
    @Override
    public void deleteApptById(String id) {
        apptRepository.deleteById(id);
    }


}
