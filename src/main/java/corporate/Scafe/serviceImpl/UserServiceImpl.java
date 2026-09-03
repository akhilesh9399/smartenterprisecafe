package corporate.Scafe.serviceImpl;

import corporate.Scafe.dto.CreateEmployeeRequest;
import corporate.Scafe.entity.*;
import corporate.Scafe.exception.custom.ResourceNotFoundException;
import corporate.Scafe.repository.*;
import corporate.Scafe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LocationRepository locationRepository;
    private final TowerRepository towerRepository;
    private final FloorRepository floorRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String createEmployee(CreateEmployeeRequest request) {

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role not found"));

        Location location = locationRepository
                .findById(request.getLocationId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Location not found"));

        Tower tower = towerRepository
                .findById(request.getTowerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tower not found"));

        Floor floor = floorRepository
                .findById(request.getFloorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Floor not found"));

        User user = User.builder()
                .employeeId(request.getEmployeeId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode("Welcome@123"))
                .role(role)
                .location(location)
                .tower(tower)
                .floor(floor)
                .active(true)
                .build();

        userRepository.save(user);

        return "Employee Created Successfully";
    }
}