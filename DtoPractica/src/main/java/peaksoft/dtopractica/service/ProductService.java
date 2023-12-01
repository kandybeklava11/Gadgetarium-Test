package peaksoft.dtopractica.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dtopractica.dto.ProductDTO;
import peaksoft.dtopractica.entity.Product;
import peaksoft.dtopractica.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    public Product create(ProductDTO dto){
       return productRepository.save(Product.builder()
               .name(dto.getName())
               .amount(dto.getAmount())
               .build());
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }

//    public Product update(Product produ    public void assingProductToMarket(Market market){
//       productRepository.findById(market.getId())
//               .orElseThrow(() -> new EntityNotFoundException("Market not found with id: " + market.getId()));
//        market.setProducts(market.getProducts());
//    }ct){
//        return productRepository.save(product);
// }

    public void delete(Long id){
         productRepository.deleteById(id);
    }
//
}
