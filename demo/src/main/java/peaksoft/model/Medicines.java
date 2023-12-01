package peaksoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @PositiveOrZero(message = "Price must be greater than or equal to 0")
    private int price;

    @ManyToMany(mappedBy = "medicines")
    private List<Pharmacy> pharmacies;
}
