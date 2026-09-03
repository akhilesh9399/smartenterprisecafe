package corporate.Scafe.repository;




import corporate.Scafe.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository
        extends JpaRepository<Location, Long> {
}