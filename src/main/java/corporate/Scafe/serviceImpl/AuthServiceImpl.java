package corporate.Scafe.serviceImpl;

import corporate.Scafe.dto.AuthResponse;
import corporate.Scafe.dto.LoginRequest;
import corporate.Scafe.dto.RegisterRequest;

import corporate.Scafe.entity.Role;
import corporate.Scafe.entity.User;
import corporate.Scafe.exception.custom.BadRequestException;
import corporate.Scafe.exception.custom.ResourceNotFoundException;
import corporate.Scafe.repository.RoleRepository;
import corporate.Scafe.repository.UserRepository;
import corporate.Scafe.security.jwt.JwtService;
import corporate.Scafe.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        Role role = roleRepository
                .findByRoleName(request.getRole())
                .orElseThrow(() ->
            new ResourceNotFoundException("Role not found"));

        User user = User.builder()
                .employeeId(request.getEmployeeId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .message("User Registered Successfully")
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"
                        ));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {

            throw new BadRequestException(
                    "Invalid Email or Password"
            );
        }

        String token = jwtService.generateToken(
                user.getEmail()
        );

        return AuthResponse.builder()
                .token(token)
                .role(user.getRole().getRoleName())
                .message("Login Successful")
                .build();
    }
}