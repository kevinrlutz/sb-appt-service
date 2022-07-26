package com.perficient.apptservice.repositories;

import com.perficient.apptservice.web.model.ApptDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RA on 06-30-2022.
 */

@Repository
public interface ApptRepository extends MongoRepository<ApptDto, String> {

    List<ApptDto> findByApptNameIgnoreCase(String name);

    List<ApptDto> findByUserId(String userId);

    long count();

}
