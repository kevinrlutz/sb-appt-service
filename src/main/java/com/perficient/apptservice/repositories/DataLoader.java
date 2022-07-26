package com.perficient.apptservice.repositories;

import com.perficient.apptservice.web.model.ApptDto;

import com.perficient.apptservice.web.model.ApptTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.time.LocalDateTime;

@Slf4j
public class DataLoader implements ApplicationRunner {

    private ApptRepository apptRepository;

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(ApptRepository apptRepository) {
        this.apptRepository = apptRepository;
    }

    public void run(ApplicationArguments args) {
        apptRepository.save(new ApptDto("xyz", "Doctor Consultation", ApptTypeEnum.OPTOMETRIST, "Provide treatment plan for symptoms.", LocalDateTime.now() , LocalDateTime.now(), "None.", "abc"));
        logger.info("MongoDB pre-loaded successfully with sample data");
    }
}
