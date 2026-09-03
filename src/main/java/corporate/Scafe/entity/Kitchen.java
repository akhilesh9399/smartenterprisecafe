package corporate.Scafe.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kitchens")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kitchenName;

    @ManyToOne
    @JoinColumn(name = "tower_id")
    private Tower tower;

    private Boolean active;
}