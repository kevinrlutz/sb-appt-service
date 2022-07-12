package com.perficient.apptservice.web.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * Created by RA on 06-30-2022.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "appointments")
public class ApptDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Note: UUID is not accepted by MongoDB. Use String instead.
    private String id;

    private String apptName;

    private ApptTypeEnum apptType;

    private String description;

    // Note: OffsetDateTime does not persist directly onto MongoDB. Converter is needed (see MongoConfig.java).
    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    // Choose appropriate data type (map?)
    private String metadata;

}
