package com.project.connection.entity;

import jakarta.persistence.*;
import lombok.Data;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "industry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Industry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "industry_name", length = 255)
    private String industryName;
}
