package lk.ijse.cropmonitoringsystembackend.dto;


import lk.ijse.cropmonitoringsystembackend.customObj.VehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto implements Serializable , VehicleResponse {
    private String vCode;
    private String category;
    private String fuelType;
    private String licensePlateNo;
    private String remark;
    private String status;
    private String assignedStaffId;
}
