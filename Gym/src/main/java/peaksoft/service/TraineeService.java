package peaksoft.service;

import peaksoft.dto.TraineeResponse;
import peaksoft.model.Trainee;
import peaksoft.model.Trainer;
import peaksoft.model.Training;

import java.util.List;

public interface TraineeService {
    List<TraineeResponse> getTraineeByUsername(String username);
    void deleteTraineeByUsername(String username);
    void changeTraineePassword(String username, String newPassword);
    void updateTraineeProfile(Trainee trainee);
    void activateDeactivateTrainee(String username, boolean activate);
    List<Training> getTraineeTrainingsList(String username, String criteria);
    List<Trainer> getNotAssignedTrainersList(String traineeUsername);
    void updateTraineeTrainersList(String traineeUsername, List<Trainer> trainers);

}
