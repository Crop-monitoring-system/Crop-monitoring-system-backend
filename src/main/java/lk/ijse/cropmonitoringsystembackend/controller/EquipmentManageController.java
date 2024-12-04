package lk.ijse.cropmonitoringsystembackend.controller;


import lk.ijse.cropmonitoringsystembackend.dto.EquipmentDto;
import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.service.EquipmentServise;
import lk.ijse.cropmonitoringsystembackend.service.FieldServise;
import lk.ijse.cropmonitoringsystembackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipment")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentManageController {


    private AvailabilityStatus availabilityStatus;
    //
    @Autowired
    private final EquipmentServise equipmentServise;







    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveEquipment(
            @RequestPart("eId") String eId,
            @RequestPart("name") String name,
            @RequestPart("status") String status,
            @RequestPart("type") String type,  // updated to camelCase
            @RequestPart("assignedFieldId") String assignedFieldId,  // updated to camelCase
            @RequestPart("assignedStaffId") String assignedStaffId) {

        try {

            EquipmentDto equipmentDto = new EquipmentDto();
            equipmentDto.setEId(eId);
            equipmentDto.setName(name);
            equipmentDto.setStatus(status);

            equipmentDto.setType(type);  // updated to camelCase
            equipmentDto.setAssignedFieldId(assignedFieldId);  // updated to camelCase
            equipmentDto.setAssignedStaffId(assignedStaffId);

            // Save crop using the service
            equipmentServise.saveEquipment(equipmentDto);


            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }





    @GetMapping(value = "equipmentAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDto> getAllFields() {
        return equipmentServise.getAllequipment(); // Use the injected service instance
    }



    @DeleteMapping("/{eId}")
    public ResponseEntity<Void> deleteFildes(@PathVariable ("eId") String equipmentId) {
        try {
            equipmentServise.deleteEquipment(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    value = "/{updateCode}",

    @PatchMapping(value = "/{updateEcode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateFields(
            @PathVariable("updateEcode") String updateFCode,
            @RequestPart("name") String name,
            @RequestPart("status") String status,
            @RequestPart("type") String type,  // updated to camelCase
            @RequestPart("assignedFieldId") String assignedFieldId,  // updated to camelCase
            @RequestPart("assignedStaffId") String assignedStaffId){

        try {


            EquipmentDto equipmentDto = new EquipmentDto();
            equipmentDto.setEId(updateFCode);
            equipmentDto.setName(name);
            equipmentDto.setStatus(status);

            equipmentDto.setType(type);  // updated to camelCase
            equipmentDto.setAssignedFieldId(assignedFieldId);  // updated to camelCase
            equipmentDto.setAssignedStaffId(assignedStaffId);

            equipmentServise.updateEquipment(equipmentDto);
            System.out.println("Endpoint hit with updateCode: " + updateFCode);


            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }














}
