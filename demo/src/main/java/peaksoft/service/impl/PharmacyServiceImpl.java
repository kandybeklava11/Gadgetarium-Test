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
import peaksoft.service.PharmacyService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor


public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    private PharmacyRepo pharmacyRepo;
    @Autowired
    private WorkerRepo workerRepo;


    @Override
    public void save(Pharmacy pharmacy) {
        pharmacyRepo.save(pharmacy);
    }

    @Override
    public void update(Long id, Pharmacy pharmacy) {
        Optional<Pharmacy> optionalExistingPharmacy = pharmacyRepo.findById(id);

        if (optionalExistingPharmacy.isPresent()) {
            Pharmacy existingPharmacy = optionalExistingPharmacy.get();
            existingPharmacy.setName(pharmacy.getName());
            existingPharmacy.setAddress(pharmacy.getAddress());
//            existingPharmacy.setMedicines(pharmacy.getMedicines());
//            existingPharmacy.setWorkers(pharmacy.getWorkers());

            pharmacyRepo.save(existingPharmacy);
        }
    }

    @Override
    public void delete(Long pharmacyId) {
        pharmacyRepo.deleteById(pharmacyId);
    }

    @Override
    public Pharmacy findById(Long id) {
        Optional<Pharmacy> optionalMedicines = pharmacyRepo.findById(id);
        return optionalMedicines.orElse(null);
    }

    @Override
    public List<Pharmacy> getAllMedicinesByPharmacyId(Long id) {
        Optional<Pharmacy> optionalPharmacy = pharmacyRepo.findById(id);

        if (optionalPharmacy.isPresent()) {
            Pharmacy pharmacy = optionalPharmacy.get();
            return pharmacyRepo.findAllByPharmacy(pharmacy);
        } else {
            throw new EntityNotFoundException("Pharmacy not found for id: " + id);
        }
    }


    @Override
    public List<Pharmacy> getPharmacyByWorkerId(Long id) {
        Optional<Worker> optionalWorker = workerRepo.findById(id);

        if (optionalWorker.isPresent()) {
            Worker worker = optionalWorker.get();
            return pharmacyRepo.findAllByWorkers(worker);
        } else {
            throw new EntityNotFoundException("Worker not found for id: " + id);
        }
    }
}
