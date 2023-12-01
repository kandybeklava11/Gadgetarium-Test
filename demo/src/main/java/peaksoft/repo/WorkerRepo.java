package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import peaksoft.model.Pharmacy;
import peaksoft.model.Worker;

import java.util.List;

@RepositoryRestResource(path = "workers")

public interface WorkerRepo extends JpaRepository<Worker,Long> {
    List<Worker> findAllByWorker(Worker worker);
    List<Worker> findAllByOrderBySalaryAsc();
    List<Worker> findAllByOrderBySalaryDesc();
}
