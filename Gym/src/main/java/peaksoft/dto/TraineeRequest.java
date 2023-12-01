package peaksoft.dto;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import peaksoft.model.Trainer;
import peaksoft.model.Training;
import peaksoft.model.User;

import java.time.LocalDate;
import java.util.List;
@Data

public class TraineeRequest {
    private String firstName;
    private String lastName;

}
