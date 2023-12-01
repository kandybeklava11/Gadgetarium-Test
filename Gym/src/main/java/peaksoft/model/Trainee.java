package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate DateOfBirth;
    private String address;
    @OneToOne
    private User user;
    @ManyToMany(mappedBy = "trainee")
    private List<Trainer> trainers;
    @OneToOne
    private Training training;
}
