package peaksoft.service;

import peaksoft.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    void save (Pharmacy pharmacy);
    void update (Long id,Pharmacy pharmacy);
    void delete(Long pharmacyId);
    Pharmacy findById(Long id);
    List<Pharmacy>getAllMedicinesByPharmacyId(Long id);
    List<Pharmacy>getPharmacyByWorkerId(Long id);
}
