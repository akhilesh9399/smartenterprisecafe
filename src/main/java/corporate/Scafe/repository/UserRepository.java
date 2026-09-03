package corporate.Scafe.repository;


import corporate.Scafe.entity.Kitchen;
import corporate.Scafe.entity.Orders;
import corporate.Scafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByEmployeeId(String employeeId);
//    List<Orders> findByEmployee(User employee);
//    List<Orders> findByKitchen(Kitchen kitchen);
}