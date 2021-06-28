package sud.springBackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double currentPrice;
    private boolean promotion;
    private  boolean selected;
    private boolean available;
    private String photoName;
    @ManyToOne
    private Category category;


}

