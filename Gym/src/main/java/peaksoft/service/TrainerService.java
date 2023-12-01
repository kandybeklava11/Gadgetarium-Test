package peaksoft.service;

import peaksoft.model.Trainer;
import peaksoft.model.Training;

import java.util.List;

public interface TrainerService {
    Trainer getTrainerByUsername(String username);
    void deleteTrainerByUsername(String username);
    void changeTrainerPassword(String username, String newPassword);
    void updateTrainerProfile(Trainer trainer);
    void activateDeactivateTrainer(String username, boolean activate);
    List<Training> getTrainerTrainingsList(String username, String criteria);
}
