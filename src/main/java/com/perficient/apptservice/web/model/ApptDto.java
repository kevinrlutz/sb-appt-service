package com.perficient.apptservice.web.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String id;

    private String apptName;

    private ApptTypeEnum apptType;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String metadata;

    private String userId;

}
