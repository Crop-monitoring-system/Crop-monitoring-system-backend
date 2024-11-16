package lk.ijse.cropmonitoringsystembackend.controller;


import lk.ijse.cropmonitoringsystembackend.dto.CropDto;
import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.exception.UserNotRegisteredException;
import lk.ijse.cropmonitoringsystembackend.service.CropServise;
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
@RequestMapping("api/v1/Crop")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CropManageController {

    private AvailabilityStatus availabilityStatus;

    @Autowired
    private final CropServise cropServise;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("code") String code,
            @RequestPart("category") String category,
            @RequestPart("common_name") String commonName,  // updated to camelCase
            @RequestPart("crop_image") MultipartFile cropImage,  // updated to camelCase
            @RequestPart("scientific_name") String scientificName,  // updated to camelCase
            @RequestPart("season") String season,
            @RequestPart("status") String status,
            @RequestPart("field") String field) {
        try {
            if (commonName == null || commonName.trim().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Validation error
            }

            // Convert the crop image to Base64 if it's not null
            String toBase64CropPic = AppUtil.toBase64CropPic(cropImage);

            // Construct the CropDto
            CropDto cropDto = new CropDto();
            cropDto.setCode(code);
            cropDto.setCategory(category);
            cropDto.setCommonName(commonName);  // updated to camelCase
            cropDto.setCropImage(toBase64CropPic);  // updated to camelCase
            cropDto.setScientificName(scientificName);  // updated to camelCase
            cropDto.setSeason(season);
            cropDto.setStatus(status);
            cropDto.setField(field);

            // Save crop using the service
            cropServise.saveCrops(cropDto);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "cropAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDto> getAllCrops() {
        return cropServise.getAllCrop(); // Use the injected service instance
    }









//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Void> createUser(@RequestBody CropDto cropDto) {
//        if (cropDto == null) {
//
//            System.out.println("cropDto is null");
//
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        try {
//            cropServise.saveCrops(cropDto);
//
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (UserNotRegisteredException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> createCrop(@RequestBody CropDto cropDto) {
//        if (cropDto == null || cropDto.getCommon_name() == null || cropDto.getCommon_name().trim().isEmpty()) {
//            System.out.println("Validation Error: common_name is null or empty");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            cropServise.saveCrops(cropDto);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (DataPersistFailedException e) {
//            System.err.println("DataPersistFailedException: " + e.getMessage());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
