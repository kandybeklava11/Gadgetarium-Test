package peaksoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Trainee trainee;

    @OneToOne
    private Trainer trainer;

    private String trainingName;

    @ManyToOne
    private TrainingType trainingType;

    private LocalDate trainingDate;
    private int duration;
}
