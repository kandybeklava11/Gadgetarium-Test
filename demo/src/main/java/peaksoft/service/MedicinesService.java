package peaksoft.service;

import peaksoft.model.Medicines;

import java.util.List;

public interface MedicinesService {
    void save (Medicines medicines);
    void update (Long id,Medicines medicines);
    void delete(Long medicinesId);
    Medicines findById(Long id);
    List<Medicines> findAllByOrderByPriceAscc(String sort);

    List<Medicines> findAllByOrderByPriceDescc(String sort);
}
