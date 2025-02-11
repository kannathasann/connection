package com.project.connection.entity;

import jakarta.persistence.*;
import lombok.Data;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "profile_education_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileEducationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int profileId;

    @Column(name = "institute_name", length = 256)
    private String instituteName;

    @Column(name = "institute_image_url", length = 256)
    private String instituteImageUrl;

    @Column(name = "course_name", length = 256)
    private String courseName;

    @Column(name = "course_start_year", length = 256)
    private String courseStartYear;

    @Column(name = "course_end_year", length = 256)
    private String courseEndYear;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
