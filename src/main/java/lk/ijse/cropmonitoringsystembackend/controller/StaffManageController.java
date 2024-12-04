package lk.ijse.cropmonitoringsystembackend.controller;


import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;
import lk.ijse.cropmonitoringsystembackend.dto.StaffDto;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.enums.Designation;
import lk.ijse.cropmonitoringsystembackend.enums.Gender;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.service.FieldServise;
import lk.ijse.cropmonitoringsystembackend.service.StaffServise;
import lk.ijse.cropmonitoringsystembackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StaffManageController {



    private AvailabilityStatus availabilityStatus;

    @Autowired
    private final StaffServise staffServise;




    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveStaff(
            @RequestPart("sId") String sId,
            @RequestPart("address") String address,
            @RequestPart("designation") String designation,
            @RequestPart("dob") String dob,
            @RequestPart("email") String email,
            @RequestPart("gender") String gender,
            @RequestPart("joined_date") String joined_date,
            @RequestPart("mobile") String mobile,
            @RequestPart("name") String name,
            @RequestPart("postalcode") String postalcode,
            @RequestPart("role") String role,
            @RequestPart("status") String status) {

        try {
            // Create and populate StaffDto
            StaffDto staffDto = new StaffDto();
            staffDto.setId(sId); // Ensure the id matches expected data type
            staffDto.setAddress(address);
            staffDto.setDesignation(designation);
            staffDto.setDob(dob);
            staffDto.setEmail(email);
            staffDto.setGender(gender);
            staffDto.setJoined_date(joined_date);
            staffDto.setMobile(mobile);
            staffDto.setName(name);
            staffDto.setPostalcode(postalcode);
            staffDto.setRole(role);
            staffDto.setStatus(status);

            // Save staff using the service instance
            staffServise.saveStaff(staffDto);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






    @GetMapping(value = "StaffdAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDto> getAllStaff() {
        return staffServise.getAllStaff(); // Use the injected service instance
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable ("id") String staffCode) {
        try {
            staffServise.deletestaff(staffCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    value = "/{updateCode}",

    @PatchMapping(value = "/{updatesId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateStaff(
            @PathVariable("updatesId") String updateFCode,
            @RequestPart("address") String address,
            @RequestPart("designation") String designation,
            @RequestPart("dob") String dob,
            @RequestPart("email") String email,
            @RequestPart("gender") String gender,
            @RequestPart("joined_date") String joined_date,
            @RequestPart("mobile") String mobile,
            @RequestPart("name") String name,
            @RequestPart("postalcode") String postalcode,
            @RequestPart("role") String role,
            @RequestPart("status") String status){

        try {
            StaffDto staffDto = new StaffDto();
            staffDto.setId(updateFCode); // Ensure the id matches expected data type
            staffDto.setAddress(address);
            staffDto.setDesignation(designation);
            staffDto.setDob(dob);
            staffDto.setEmail(email);
            staffDto.setGender(gender);
            staffDto.setJoined_date(joined_date);
            staffDto.setMobile(mobile);
            staffDto.setName(name);
            staffDto.setPostalcode(postalcode);
            staffDto.setRole(role);
            staffDto.setStatus(status);

            staffServise.updateStaff(staffDto);
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
