package lk.ijse.cropmonitoringsystembackend.dto;


import lk.ijse.cropmonitoringsystembackend.customObj.FieldResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDto implements Serializable, FieldResponse {

    private String fcode;
    private String fieldImage1;
    private String fieldImage2;
    private String location;
    private String name;
    private String size;
    private String status;

//    private String fieldId;
//    private String staffId;
}
