package peaksoft.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Pharmacy;
import peaksoft.model.Worker;
import peaksoft.repo.PharmacyRepo;
import peaksoft.repo.WorkerRepo;
import peaksoft.service.WorkerService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class WorkerServiceImpl implements WorkerService {
    @Autowired

    private WorkerRepo workerRepo;
    @Autowired
    private PharmacyRepo pharmacyRepo;
    @Override
    public void save(Worker worker) {
    workerRepo.save(worker);
    }

    @Override
    public void update(Long id, Worker worker) {
        Optional<Worker> optionalExistingMedicines = workerRepo.findById(id);

        if (optionalExistingMedicines.isPresent()) {

            Worker existingMedicines = optionalExistingMedicines.get();
            existingMedicines.setName(worker.getName());
            existingMedicines.setAddress(worker.getAddress());
            existingMedicines.setEmail(worker.getEmail());
            existingMedicines.setDateOfBirth(worker.getDateOfBirth());
            existingMedicines.setDateOfBirth(worker.getDateOfBirth());

            workerRepo.save(existingMedicines);
        }
    }

    @Override
    public void delete(Long workerId) {
    workerRepo.deleteById(workerId);
    }

    @Override
    public Worker findById(Long id) {
        Optional<Worker> optionalMedicines = workerRepo.findById(id);
        return optionalMedicines.orElse(null);
    }

    @Override
    public List<Pharmacy> getAllWorkersByPharmacyId(Long id) {
        Optional<Pharmacy> optionalPharmacy = pharmacyRepo.findById(id);

        if (optionalPharmacy.isPresent()) {
            Pharmacy pharmacy = optionalPharmacy.get();
            return pharmacyRepo.findAllByPharmacy(pharmacy);
        } else {
            throw new EntityNotFoundException("Workers not found for id: " + id);
        }
    }

    @Override
    public List<Worker> getAllSalaryBySort(String sort) {
        if ("asc".equalsIgnoreCase(sort)) {
            return workerRepo.findAllByOrderBySalaryAsc();
        } else if ("desc".equalsIgnoreCase(sort)) {
            return workerRepo.findAllByOrderBySalaryDesc();
        }
        return List.of();
    }
}
