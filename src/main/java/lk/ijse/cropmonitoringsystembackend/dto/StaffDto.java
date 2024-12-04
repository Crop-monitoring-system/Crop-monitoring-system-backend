package lk.ijse.cropmonitoringsystembackend.dto;


import lk.ijse.cropmonitoringsystembackend.customObj.StaffResponse;
import lk.ijse.cropmonitoringsystembackend.enums.Designation;
import lk.ijse.cropmonitoringsystembackend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDto implements Serializable , StaffResponse {

    private String  id;
    private String address;
    private String designation;
    private String dob;
    private String email;
    private String gender;
    private String joined_date;
    private String mobile;
    private String name;
    private String postalcode;
    private String role;
    private String status;

}
