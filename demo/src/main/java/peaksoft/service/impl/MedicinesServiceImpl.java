package peaksoft.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Medicines;
import peaksoft.repo.MedicinesRepo;
import peaksoft.service.MedicinesService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class MedicinesServiceImpl implements MedicinesService {
    @Autowired
    private MedicinesRepo medicinesRepo;


    @Override
    public void save(Medicines medicines) {
        medicinesRepo.save(medicines);
    }

    @Override
    public void update(Long id, Medicines medicines) {
        Optional<Medicines> optionalExistingMedicines = medicinesRepo.findById(id);

        if (optionalExistingMedicines.isPresent()) {

            Medicines existingMedicines = optionalExistingMedicines.get();
            existingMedicines.setName(medicines.getName());
            existingMedicines.setPrice(medicines.getPrice());
        //    existingMedicines.setPharmacies(medicines.getPharmacies());

            medicinesRepo.save(existingMedicines);
        }
    }

    @Override
    public void delete(Long medicinesId) {
        medicinesRepo.deleteById(medicinesId);
    }

    @Override
    public Medicines findById(Long id) {
        Optional<Medicines> optionalMedicines = medicinesRepo.findById(id);
        return optionalMedicines.orElse(null);
    }

    @Override
    public List<Medicines> findAllByOrderByPriceAscc(String sort) {
        if ("asc".equalsIgnoreCase(sort)) {
            return medicinesRepo.findAllByOrderByPriceAsc();
        } else {
            throw new IllegalArgumentException("Invalid sort parameter");
        }
    }

    @Override
    public List<Medicines> findAllByOrderByPriceDescc(String sort) {
        if ("desc".equalsIgnoreCase(sort)) {
            return medicinesRepo.findAllByOrderByPriceDesc();
        } else {
            throw new IllegalArgumentException("Invalid sort parameter");
        }
    }
}
