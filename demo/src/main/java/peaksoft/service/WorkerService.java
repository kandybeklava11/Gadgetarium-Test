package peaksoft.service;

import peaksoft.model.Pharmacy;
import peaksoft.model.Worker;

import java.util.List;

public interface WorkerService {
    void save (Worker worker);
    void update (Long id,Worker worker);
    void delete(Long workerId);
    Worker findById(Long id);
    List<Pharmacy>getAllWorkersByPharmacyId(Long id);
    List<Worker>getAllSalaryBySort(String sort);
}
