package peaksoft.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import peaksoft.model.Medicines;
import peaksoft.model.Pharmacy;

import java.util.List;

@RepositoryRestResource(path = "medicines")
public interface MedicinesRepo extends JpaRepository<Medicines,Long> {
    List<Medicines> findAllByOrderByPriceAsc();

    List<Medicines> findAllByOrderByPriceDesc();

}
