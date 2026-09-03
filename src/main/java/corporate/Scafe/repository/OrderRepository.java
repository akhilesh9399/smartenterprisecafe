package corporate.Scafe.repository;



import corporate.Scafe.entity.Kitchen;
import corporate.Scafe.entity.Orders;
import corporate.Scafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository
        extends JpaRepository<Orders, Long> {

    List<Orders> findByKitchen(Kitchen kitchen);
    List<Orders> findByEmployee(User employee);
}