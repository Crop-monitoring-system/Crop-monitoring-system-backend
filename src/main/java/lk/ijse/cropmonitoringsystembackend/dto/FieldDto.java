package lk.ijse.cropmonitoringsystembackend.dto;


import lk.ijse.cropmonitoringsystembackend.customObj.FieldResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.awt.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDto implements Serializable, FieldResponse {

    private String fcode;
    private String fieldImage1;
    private String fieldImage2;
    private String fieldlocation;
    private String name;
    private String size;
    private String staff;
    private String status;

//    private String fieldId;
//    private String staffId;
}
