package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    Trainer findByUser_Username(String username);
    void deleteByUser_Username(String username);
}
