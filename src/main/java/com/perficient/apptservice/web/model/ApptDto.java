package com.perficient.apptservice.web.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalTime;

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
    // Note: UUID is not accepted by MongoDB. Use String instead.
    private String id;

    private String apptName;

    private ApptTypeEnum apptType;

    private String description;

    private LocalTime startTime;

    private LocalTime endTime;

    // Choose appropriate data type (map?)
    private String metadata;

}
