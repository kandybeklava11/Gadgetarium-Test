package peaksoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import peaksoft.enums.Specialization;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Specialization specialization;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Trainee> trainees;

    @OneToOne(mappedBy = "trainer")
    private Training training;

    @OneToOne
    private TrainingType trainingType;
}
