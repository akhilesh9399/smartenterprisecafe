package corporate.Scafe.controller;


import corporate.Scafe.dto.CreateEmployeeRequest;
import corporate.Scafe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String createEmployee(
            @RequestBody CreateEmployeeRequest request
    ) {
        return userService.createEmployee(request);
    }
}