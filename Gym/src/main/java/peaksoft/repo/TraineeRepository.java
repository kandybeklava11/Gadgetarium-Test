package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee,Long> {
    Trainee findByUser_Username(String username);
    void deleteByUser_Username(String username);
}
