package corporate.Scafe.repository;




import corporate.Scafe.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository
        extends JpaRepository<MenuCategory, Long> {
}