package peaksoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.TraineeResponse;
import peaksoft.model.Trainee;
import peaksoft.model.Trainer;
import peaksoft.service.TraineeService;

import java.util.List;

public class TraineeController {
    private TraineeService traineeService;

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteTraineeByUsername(@PathVariable String username) {
        traineeService.deleteTraineeByUsername(username);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/change-password/{username}")
    public ResponseEntity<Void> changeTraineePassword(@PathVariable String username, @RequestParam String newPassword) {
        traineeService.changeTraineePassword(username, newPassword);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-profile")
    public ResponseEntity<Void> updateTraineeProfile(@RequestBody TraineeResponse traineeDTO) {
        Trainee trainee = .map(traineeDTO, Trainee.class);
        traineeService.updateTraineeProfile(trainee);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/activate-deactivate/{username}")
    public ResponseEntity<Void> activateDeactivateTrainee(@PathVariable String username, @RequestParam boolean activate) {
        traineeService.activateDeactivateTrainee(username, activate);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/trainings/{username}")
    public ResponseEntity<List<TrainingResponse>> getTraineeTrainingsList(@PathVariable String username, @RequestParam String criteria) {
        List<TrainingResponse> trainings = traineeService.getTraineeTrainingsList(username, criteria);
        return ResponseEntity.ok(trainings);
    }
    @GetMapping("/not-assigned-trainers/{username}")
    public ResponseEntity<List<TrainerResponse>> getNotAssignedTrainersList(@PathVariable String username) {
        List<TrainerDTO> trainers = traineeService.getNotAssignedTrainersList(username);
        return ResponseEntity.ok(trainers);
    }
    @PutMapping("/update-trainers/{username}")
    public ResponseEntity<Void> updateTraineeTrainersList(@PathVariable String username, @RequestBody List<TrainerResponse> trainers) {
        List<Trainer> trainerEntities = modelMapper.map(trainers, new TypeToken<List<Trainer>>() {}.getType());
        traineeService.updateTraineeTrainersList(username, trainerEntities);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{username}")
    public ResponseEntity<List<TraineeResponse>> getTraineeByUsername(@PathVariable String username) {
        List<TraineeResponse> trainee = traineeService.getTraineeByUsername(username);
        return ResponseEntity.ok(trainee);
    }
}
}
