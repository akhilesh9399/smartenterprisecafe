package corporate.Scafe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import corporate.Scafe.entity.MenuItem;


public interface MenuItemRepository
        extends JpaRepository<MenuItem, Long> {
}
