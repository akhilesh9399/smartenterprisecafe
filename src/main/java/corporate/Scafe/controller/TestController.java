package corporate.Scafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/v1/employee/dashboard")
    public String employeeDashboard() {

        return "Welcome Employee";
    }

    @GetMapping("/api/v1/kitchen/dashboard")
    public String kitchenDashboard() {

        return "Welcome Kitchen";
    }

    @GetMapping("/api/v1/manager/dashboard")
    public String managerDashboard() {

        return "Welcome Manager";

    }

}