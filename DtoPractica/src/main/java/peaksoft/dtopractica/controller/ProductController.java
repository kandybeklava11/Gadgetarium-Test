package peaksoft.dtopractica.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.dtopractica.dto.MarketDTO;
import peaksoft.dtopractica.dto.ProductDTO;
import peaksoft.dtopractica.entity.Market;
import peaksoft.dtopractica.entity.Product;
import peaksoft.dtopractica.repository.MarketRepository;
import peaksoft.dtopractica.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final MarketRepository marketRepository;
    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto){
        return  new ResponseEntity<>(productService.create(dto), HttpStatus.OK);
    }

    @GetMapping("raedAll")
    public ResponseEntity<List<Product>>readAll(){
    return new ResponseEntity<>(productService.readAll(),HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<Product>update(@RequestBody Product product){
    return new ResponseEntity<>(productService.update(product),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
    productService.delete(id);
    return HttpStatus.OK;
    }
    @PutMapping("assing")
    public ResponseEntity<Market> assingProductToMarket(@RequestBody Market market) {
        Market existingMarket = marketRepository.findById(market.getId())
                .orElseThrow(() -> new EntityNotFoundException("Market not found with id: " + market.getId()));

        existingMarket.setProducts(market.getProducts());

        marketRepository.save(existingMarket);

        return new ResponseEntity<>(existingMarket, HttpStatus.OK);
    }
    }

