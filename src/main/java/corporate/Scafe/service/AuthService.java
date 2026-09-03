package corporate.Scafe.service;

import corporate.Scafe.dto.AuthResponse;
import corporate.Scafe.dto.LoginRequest;
import corporate.Scafe.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);

}
