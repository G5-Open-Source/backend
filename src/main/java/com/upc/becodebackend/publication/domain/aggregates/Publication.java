package com.upc.becodebackend.publication.domain.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
@Setter
    private Long id;
    @Getter
    @Setter
    private String title;
    @Getter
@Setter
    private String description;
    @Getter
@Setter
    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
    @Getter
    @Setter
    private String freelancerId;
}
