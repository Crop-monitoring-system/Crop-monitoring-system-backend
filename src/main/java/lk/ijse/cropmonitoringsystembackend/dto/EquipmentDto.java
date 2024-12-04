package lk.ijse.cropmonitoringsystembackend.dto;

import lk.ijse.cropmonitoringsystembackend.customObj.EquipmentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto implements Serializable , EquipmentResponse {

    private String eId; // Equipment ID
    private String name; // Name of the equipment
    private String status; // Status (e.g., ACTIVE, AVAILABLE)
    private String type; // Type of equipment (e.g., FERTILIZER_APPLICATOR)
    private String assignedFieldId; // Field ID where the equipment is assigned
    private String assignedStaffId; // Staff ID to whom the equipment is assigned
}
