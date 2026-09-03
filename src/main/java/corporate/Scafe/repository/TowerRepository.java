package corporate.Scafe.repository;




import corporate.Scafe.entity.Tower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowerRepository
        extends JpaRepository<Tower, Long> {
}