package corporate.Scafe.dto;

import lombok.Data;

@Data
public class CreateEmployeeRequest {

    private String employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private Long roleId;

    private Long locationId;

    private Long towerId;

    private Long floorId;
}