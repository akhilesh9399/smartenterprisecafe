package corporate.Scafe.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

}
