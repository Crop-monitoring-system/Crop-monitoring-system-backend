package lk.ijse.cropmonitoringsystembackend.controller;

import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;

import lk.ijse.cropmonitoringsystembackend.service.FieldServise;
import lk.ijse.cropmonitoringsystembackend.service.Field_staffServise;
import lk.ijse.cropmonitoringsystembackend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/Field")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FieldManegeController {

    private AvailabilityStatus availabilityStatus;
//
    @Autowired
    private final FieldServise fieldServise;


    @Autowired
    private final Field_staffServise fieldStaffServise;




//    orginal code

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Void> saveField(
//            @RequestPart("fcode") String fcode,
//            @RequestPart("FieldImage1") MultipartFile FieldImage1,
//            @RequestPart("FieldImage2") MultipartFile FieldImage2,
//            @RequestPart("fieldlocation") String fieldlocation,  // updated to camelCase
//            @RequestPart("name") String name,  // updated to camelCase
//            @RequestPart("size") String size,
//            @RequestPart("status") String status) {
//
//        try {
//
//            // Convert the crop image to Base64 if it's not null
//            String toBase64FieldPic1 = AppUtil.toBase64FieldPic1(FieldImage1);
//            String toBase64FieldPic2 = AppUtil.toBase64FieldPic2(FieldImage2);
//
//            // Construct the FieldDto
//
//
//
//
//
//
//            FieldDto fieldDto = new FieldDto();
//            fieldDto.setFcode(fcode);
//            fieldDto.setFieldImage1(toBase64FieldPic1);
//            fieldDto.setFieldImage2(toBase64FieldPic2);
//
//            fieldDto.setFieldlocation(fieldlocation);  // updated to camelCase
//            fieldDto.setName(name);  // updated to camelCase
//            fieldDto.setSize(size);
//            fieldDto.setStatus(status);
//
//            // Save crop using the service
//            fieldServise.saveField(fieldDto);
//
//
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (DataPersistFailedException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
















    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fcode") String fcode,
            @RequestPart("FieldImage1") MultipartFile FieldImage1,
            @RequestPart("FieldImage2") MultipartFile FieldImage2,
            @RequestPart("fieldlocation") String fieldlocation,
            @RequestPart("name") String name,
            @RequestPart("size") String size,
            @RequestPart("staff") String staffIds,
            @RequestPart("status") String status) {

        try {
            // Convert field images to Base64
            String toBase64FieldPic1 = AppUtil.toBase64FieldPic1(FieldImage1);
            String toBase64FieldPic2 = AppUtil.toBase64FieldPic2(FieldImage2);

            // Construct and save FieldDto
            FieldDto fieldDto = new FieldDto();
            fieldDto.setFcode(fcode);
            fieldDto.setFieldImage1(toBase64FieldPic1);
            fieldDto.setFieldImage2(toBase64FieldPic2);
            fieldDto.setFieldlocation(fieldlocation);
            fieldDto.setName(name);
            fieldDto.setSize(size);
            fieldDto.setStatus(status);

            // Save field using the service
            fieldServise.saveField(fieldDto);

            // Share and save the field-staff relationship

                fieldStaffServise.saveFieldStaff(fcode, staffIds);


            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }























    @GetMapping(value = "fieldAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDto> getAllFields() {
        return fieldServise.getAllFields(); // Use the injected service instance
    }



    @DeleteMapping("/{fcode}")
    public ResponseEntity<Void> deleteFildes(@PathVariable ("fcode") String feildCode) {
        try {
            fieldServise.deleteFields(feildCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





//    orginal code

//    value = "/{updateCode}",

//    @PatchMapping(value = "/{updateFCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Void> updateFields(
//            @PathVariable("updateFCode") String updateFCode,
//            @RequestPart("FieldImage1") MultipartFile FieldImage1,
//            @RequestPart("FieldImage2") MultipartFile FieldImage2,
//            @RequestPart("fieldlocation") String fieldlocation,  // updated to camelCase
//            @RequestPart("name") String name,  // updated to camelCase
//            @RequestPart("size") String size,
//            @RequestPart("status") String status) {
//
//        try {
//            String toBase64FieldPic1 = AppUtil.toBase64FieldPic1(FieldImage1);
//            String toBase64FieldPic2 = AppUtil.toBase64FieldPic2(FieldImage2);
//
//            FieldDto fieldDto = new FieldDto();
//            fieldDto.setFcode(updateFCode);
//            fieldDto.setFieldImage1(toBase64FieldPic1);
//            fieldDto.setFieldImage2(toBase64FieldPic2);
//
//            fieldDto.setFieldlocation(fieldlocation);  // updated to camelCase
//            fieldDto.setName(name);  // updated to camelCase
//            fieldDto.setSize(size);
//            fieldDto.setStatus(status);
//
//            fieldServise.updateFields(fieldDto);
//            System.out.println("Endpoint hit with updateCode: " + updateFCode);
//
//
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (CropNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//










    @PatchMapping(value = "/{updateFCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateFields(
            @PathVariable("updateFCode") String updateFCode,
            @RequestPart("FieldImage1") MultipartFile FieldImage1,
            @RequestPart("FieldImage2") MultipartFile FieldImage2,
            @RequestPart("fieldlocation") String fieldlocation,  // updated to camelCase
            @RequestPart("name") String name,  // updated to camelCase
            @RequestPart("size") String size,
            @RequestPart("staff") String staffIds,
            @RequestPart("status") String status) {

        try {
            String toBase64FieldPic1 = AppUtil.toBase64FieldPic1(FieldImage1);
            String toBase64FieldPic2 = AppUtil.toBase64FieldPic2(FieldImage2);

            FieldDto fieldDto = new FieldDto();
            fieldDto.setFcode(updateFCode);
            fieldDto.setFieldImage1(toBase64FieldPic1);
            fieldDto.setFieldImage2(toBase64FieldPic2);

            fieldDto.setFieldlocation(fieldlocation);  // updated to camelCase
            fieldDto.setName(name);  // updated to camelCase
            fieldDto.setSize(size);
            fieldDto.setStatus(status);

            fieldServise.updateFields(fieldDto);
            System.out.println("Endpoint hit with updateCode: " + updateFCode);


            fieldStaffServise.updateFieldStaff(updateFCode, staffIds);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}






