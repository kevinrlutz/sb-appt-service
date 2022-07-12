package com.perficient.apptservice.repositories;

import com.perficient.apptservice.web.model.ApptDto;
import com.perficient.apptservice.web.model.ApptTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private ApptRepository apptRepository;

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(ApptRepository apptRepository) {
        this.apptRepository = apptRepository;
    }

    public void run(ApplicationArguments args) {
        apptRepository.save(new ApptDto("cd71df6c-20a6-48d0-bb96-2514a90619e1", "Doctor Consultation", ApptTypeEnum.INITIAL, "Provide treatment plan for symptoms.", OffsetDateTime.now() , OffsetDateTime.now(), "None."));
        logger.info("MongoDB pre-loaded successfully with sample data");
    }
}
