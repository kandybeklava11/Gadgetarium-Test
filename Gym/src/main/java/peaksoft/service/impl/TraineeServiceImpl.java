package peaksoft.service.impl;

import jakarta.persistence.EntityNotFoundException;
import peaksoft.dto.TraineeResponse;
import peaksoft.model.Trainee;
import peaksoft.model.Trainer;
import peaksoft.model.Training;
import peaksoft.repo.TraineeRepository;
import peaksoft.service.TraineeService;

import java.util.List;

public class TraineeServiceImpl implements TraineeService {
    private TraineeRepository traineeRepository;
    @Override
    public List<TraineeResponse> getTraineeByUsername(String username) {
    Trainee trainee = traineeRepository.findByUser_Username(username)
            .orElseThrow(() -> new EntityNotFoundException("Trainee not found with username: " + username));

        return modelMapper.map(trainee,TraineeResponse .class);
}



    @Override
    public void deleteTraineeByUsername(String username) {
        Trainee trainee = traineeRepository.findByUser_UserName(username)
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with username: " + username));

        traineeRepository.delete(trainee);
    }

    @Override
    public void changeTraineePassword(String username, String newPassword) {
        Trainee trainee = traineeRepository.findByUser_UserName(username)
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with username: " + username));

        trainee.getUser().setPassword(newPassword);
        traineeRepository.save(trainee);
    }

    @Override
    public void updateTraineeProfile(Trainee trainee) {
        Trainee existingTrainee = traineeRepository.findById(trainee.getId())
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with id: " + trainee.getId()));

        // Обновление полей
        existingTrainee.setDateOfBirth(trainee.getDateOfBirth());
        existingTrainee.setAddress(trainee.getAddress());
        // Обновление других полей

        traineeRepository.save(existingTrainee);
    }

    @Override
    public void activateDeactivateTrainee(String username, boolean activate) {
        Trainee trainee = traineeRepository.findByUser_UserName(username)
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with username: " + username));

        trainee.getUser().setActive(activate);
        traineeRepository.save(trainee);
    }

    @Override
    public List<Training> getTraineeTrainingsList(String username, String criteria) {
        // Реализуйте логику получения списка тренировок для Trainee по username и criteria
        // ...
        return null;
    }

    @Override
    public List<Trainer> getNotAssignedTrainersList(String traineeUsername) {
        // Реализуйте логику получения списка не назначенных тренеров для Trainee
        // ...
        return null;
    }

    @Override
    public void updateTraineeTrainersList(String traineeUsername, List<Trainer> trainers) {
        Trainee trainee = traineeRepository.findByUser_UserName(traineeUsername)
                .orElseThrow(() -> new EntityNotFoundException("Trainee not found with username: " + traineeUsername));

        trainee.setTrainers(trainers);
        traineeRepository.save(trainee);
    }
}
