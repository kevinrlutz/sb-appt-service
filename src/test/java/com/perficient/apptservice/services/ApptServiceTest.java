package com.perficient.apptservice.services;

import com.perficient.apptservice.repositories.ApptRepository;
import com.perficient.apptservice.web.model.ApptDto;
import com.perficient.apptservice.web.model.ApptTypeEnum;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Integration Tests
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@AutoConfigureDataMongo
public class ApptServiceTest {

    @Autowired
    ApptRepository apptRepository;

    @Autowired
    ApptService apptService;

    @Test
    void getApptById() {

        ApptDto apptDto = getValidApptDto();
        ApptDto savedAppt = apptService.saveAppt(apptDto);
        String testId = savedAppt.getId();

        ApptDto returnedApptDto = apptService.getApptById(testId);
        // System.out.println("Returned Appt: " + returnedApptDto);

        assertNotNull(returnedApptDto);

    }

    @Test
    void getApptListByUserId() throws Exception {
        ApptDto apptDto = getValidApptDto();
        apptService.saveAppt(apptDto);
        List<ApptDto> returnedApptDtoList = apptService.getApptListByUserId(apptDto.getUserId());

        assertNotNull(returnedApptDtoList);
    }

    @Test
    void getAllApptsByName() throws Exception {
        apptService.saveAppt(getValidApptDto());
        List<ApptDto> returnedApptDtoList = apptService.getAllApptsByName("Test Appt");

        assertNotNull(returnedApptDtoList);
    }

    @Test
    void saveAppt() {

        ApptDto apptDto = getValidApptDto();

        ApptDto savedAppt = apptService.saveAppt(apptDto);
        System.out.println("Saved Appt: " + savedAppt);

        assertNotNull(savedAppt);
    }

    @Test
    void updateAppt() {

        ApptDto apptDto = getValidApptDto();
        ApptDto savedAppt = apptService.saveAppt(apptDto);

        System.out.println("Saved Appt: " + savedAppt);

        ApptDto updateDto = ApptDto.builder()
                .apptName("Update Appt")
                .apptType(ApptTypeEnum.DENTIST)
                .description("Updated description.")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .metadata("N/A")
                .build();

        ApptDto updatedAppt = apptService.updateAppt(updateDto, savedAppt.getId());
        System.out.println("Updated Appt: " + updatedAppt);

        assertNotNull(updatedAppt);

    }

    @Test
    void deleteAppt() {
        ApptDto savedAppt = apptService.saveAppt(getValidApptDto());
        String testId = savedAppt.getId();
        apptService.deleteApptById(testId);

        assertThat(apptRepository.findById(testId).isEmpty());
    }

    ApptDto getValidApptDto() {
        return ApptDto.builder()
                .id(new ObjectId().toString())
                .apptName("Test Appt")
                .apptType(ApptTypeEnum.PRIMARY_CARE)
                .description("Test description.")
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .metadata("N/A")
                .userId(new ObjectId().toString())
                .build();
    }

}
