package peaksoft.dtopractica.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dtopractica.dto.MarketDTO;
import peaksoft.dtopractica.entity.Market;
import peaksoft.dtopractica.repository.MarketRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class MarketService {
    private final MarketRepository marketRepository;

    public Market create(MarketDTO dto){
        return marketRepository.save(Market.builder()
                        .name(dto.getName())
                        .address(dto.getAddress())
                .build());
    }

    public List<Market>readAll(){
        return marketRepository.findAll();
    }
    public void update(Market market){
        Market market1=marketRepository.findById(market.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Market not found with id: " + market.getId()));
        market.setName(market.getName());
        market.setAddress(market.getAddress());
        marketRepository.save(market1);
    }
    public void delete(Long id){
        marketRepository.deleteById(id);
    }
}
