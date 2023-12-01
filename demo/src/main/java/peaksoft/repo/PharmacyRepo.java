package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import peaksoft.model.Medicines;
import peaksoft.model.Pharmacy;

import java.util.List;

@RepositoryRestResource(path = "pharmacy")
public interface PharmacyRepo extends JpaRepository<Pharmacy,Long> {
    List<Pharmacy> findAllByPharmacy(Pharmacy pharmacy);
    List<Pharmacy> findAllByWorker(Pharmacy pharmacy);
}
