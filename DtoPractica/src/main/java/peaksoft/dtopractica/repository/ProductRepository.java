package peaksoft.dtopractica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.dtopractica.entity.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {

}
