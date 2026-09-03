package corporate.Scafe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "towers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String towerName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(
            mappedBy = "tower",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Floor> floors;

    private Boolean active;
}