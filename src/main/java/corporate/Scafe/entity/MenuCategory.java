package corporate.Scafe.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menu_categories")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private Boolean active;

}