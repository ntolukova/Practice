package api_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Teachers {
    String premanentAddress;
    String section;
    String subject;
    int batch;
    String birthDate;
    String department;
    String gender;
    String password;
    String phone;
    String firstName;
    String lastName;
    String emailAddress;
    String joinDate;
    int salary;
    int teacherId;
}
