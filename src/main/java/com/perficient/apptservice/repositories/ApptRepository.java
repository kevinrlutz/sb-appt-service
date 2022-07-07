package com.perficient.apptservice.repositories;

import com.perficient.apptservice.web.model.ApptDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by RA on 06-30-2022.
 */

@Repository
public interface ApptRepository extends JpaRepository<ApptDto, UUID> {
}
