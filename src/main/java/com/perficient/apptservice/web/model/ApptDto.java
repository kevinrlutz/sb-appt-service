package com.perficient.apptservice.web.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotEmpty(message = "Appointment name is required.")
    private String apptName;

    @NotNull
    private ApptTypeEnum apptType;

    private String description;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    private String metadata;

    private String userId;

}
