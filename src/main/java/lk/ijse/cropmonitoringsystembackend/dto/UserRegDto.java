package lk.ijse.cropmonitoringsystembackend.dto;


import lk.ijse.cropmonitoringsystembackend.customObj.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegDto implements Serializable, UserResponse {
    private String email;
    private String password;
    private String role;

}
