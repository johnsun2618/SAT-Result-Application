package com.example.SAT_Results.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sat_results")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class SATResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String address;

    private String city;

    private String country;

    private String pincode;

    private int satScore;

    private String passed;

}
