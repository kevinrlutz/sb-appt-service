package com.perficient.apptservice.web.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by RA on 06-30-2022.
 */

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApptDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String apptName;

    private ApptTypeEnum apptType;

    private String description;

    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    // Choose appropriate data type (map?)
    private String metadata;

}
