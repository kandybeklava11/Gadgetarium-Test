package peaksoft.dtopractica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.dtopractica.entity.Market;
@Repository

public interface MarketRepository extends JpaRepository<Market,Long> {

}
