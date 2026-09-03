package corporate.Scafe.repository;




import corporate.Scafe.entity.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenRepository
        extends JpaRepository<Kitchen, Long> {
}