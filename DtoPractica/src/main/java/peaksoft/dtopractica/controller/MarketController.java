package peaksoft.dtopractica.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.dtopractica.dto.MarketDTO;
import peaksoft.dtopractica.entity.Market;
import peaksoft.dtopractica.repository.MarketRepository;
import peaksoft.dtopractica.service.MarketService;
import peaksoft.dtopractica.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/market")

public class MarketController {
    private final MarketService marketService;
    private final MarketRepository marketRepository;
    @PostMapping("create")
    public ResponseEntity<Market>create(@RequestBody MarketDTO dto){
        return new ResponseEntity<>(marketService.create(dto), HttpStatus.OK);
    }
    @GetMapping("readAll")
    public ResponseEntity<List<Market>>readAll(){
        return new ResponseEntity<>(marketService.readAll(),HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<Market> update(@RequestBody Market updatedMarket) {
        Market existingMarket = marketRepository.findById(updatedMarket.getId())
                .orElseThrow(() -> new EntityNotFoundException("Market not found with id: " + updatedMarket.getId()));

        marketService.update(existingMarket);

        return new ResponseEntity<>(existingMarket, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        marketService.delete(id);
        return HttpStatus.OK;
    }

}
