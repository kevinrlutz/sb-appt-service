package com.perficient.apptservice.repositories;

import com.perficient.apptservice.web.model.ApptDto;
import com.perficient.apptservice.web.model.ApptTypeEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RA on 06-30-2022.
 */

@Repository
public interface ApptRepository extends MongoRepository<ApptDto, String> {

    // TODO: Add service methods for findApptByName(), findAll(), and count()
    @Query("{apptName: '?0'}")
    ApptDto findApptByName(String apptName);

    @Query(value="{apptType: '?0'}", fields="{'id': 1, 'apptName' : 1}")
    List<ApptDto> findAll(ApptTypeEnum apptTypeEnum);

    long count();

}