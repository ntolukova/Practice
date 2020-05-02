package api_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Students {
    String firstName;
    String lastName;
    int batch;
    String joinDate;
    String major;
    String birthDate;
    String password;
    String subject;
    String gender;
    String admissionNo;
    String section;
    Contact contact;
    Company company;
}
