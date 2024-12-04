package lk.ijse.cropmonitoringsystembackend.controller;


import lk.ijse.cropmonitoringsystembackend.dto.EquipmentDto;
import lk.ijse.cropmonitoringsystembackend.dto.VehicleDto;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.service.EquipmentServise;
import lk.ijse.cropmonitoringsystembackend.service.VehicleServise;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleManageController {




    private AvailabilityStatus availabilityStatus;
    //
    @Autowired
    private final VehicleServise vehicleServise;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveEquipment(
            @RequestPart("vCode") String vCode,
            @RequestPart("category") String category,
            @RequestPart("fuelType") String fuelType,
            @RequestPart("licensePlateNo") String licensePlateNo,  // updated to camelCase
            @RequestPart("remark") String remark,
            @RequestPart("status") String status,// updated to camelCase
            @RequestPart("assignedStaffId") String assignedStaffId) {

        try {

            VehicleDto vehicleDto = new VehicleDto();
            vehicleDto.setVCode(vCode);
            vehicleDto.setCategory(category);
            vehicleDto.setFuelType(fuelType);

            vehicleDto.setLicensePlateNo(licensePlateNo);  // updated to camelCase
            vehicleDto.setRemark(remark);  // updated to camelCase
            vehicleDto.setStatus(status);
            vehicleDto.setAssignedStaffId(assignedStaffId);

            // Save crop using the service
            vehicleServise.saveVehicle(vehicleDto);


            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }







}
