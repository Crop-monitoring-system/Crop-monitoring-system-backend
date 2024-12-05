package lk.ijse.cropmonitoringsystembackend.controller;


import lk.ijse.cropmonitoringsystembackend.dto.EquipmentDto;
import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;
import lk.ijse.cropmonitoringsystembackend.dto.MonitoringLogDto;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.service.*;
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
@RequestMapping("api/v1/monitoringLog")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MonitoringLogManageController {



    private AvailabilityStatus availabilityStatus;
    //
    @Autowired
    private final MonitoringLogServise monitoringLogServise;


    @Autowired
    private final LogFieldServise logFieldServise;

    @Autowired
    private final LogStaffServise logStaffServise;

    @Autowired
    private final LogCropServise logCropServise;

//
//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Void> saveMlog(
//            @RequestPart("mCode") String mCode,
//            @RequestPart("mDate") String mDate,
//            @RequestPart("observation") String observation,
//            @RequestPart("observedImage") MultipartFile observedImage) {
//
//        try {
//
//            String toBase64FieldPic = AppUtil.toBase64FieldPic3(observedImage);
//
//            MonitoringLogDto monitoringLogDto = new MonitoringLogDto();
//
//            monitoringLogDto.setMCode(mCode);
//            monitoringLogDto.setMDate(mDate);
//            monitoringLogDto.setObservation(observation);
//            monitoringLogDto.setObservedImage(toBase64FieldPic);  // updated to camelCase
//
//
//            // Save crop using the service
//            monitoringLogServise.saveMlog(monitoringLogDto);
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
//






















































    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveMlog(
            @RequestPart("mCode") String mCode,
            @RequestPart("mDate") String mDate,
            @RequestPart("observation") String observation,
            @RequestPart("observedImage") MultipartFile observedImage,

            @RequestPart("staff") String staffid,
            @RequestPart("crop") String cropId,
            @RequestPart("field") String field){

        try {

            String toBase64FieldPic = AppUtil.toBase64FieldPic3(observedImage);

            MonitoringLogDto monitoringLogDto = new MonitoringLogDto();

            monitoringLogDto.setMCode(mCode);
            monitoringLogDto.setMDate(mDate);
            monitoringLogDto.setObservation(observation);
            monitoringLogDto.setObservedImage(toBase64FieldPic);  // updated to camelCase


            // Save crop using the service
            monitoringLogServise.saveMlog(monitoringLogDto);

            logFieldServise.save(mCode, field);
           logStaffServise.save(mCode, staffid);
            logCropServise.save(mCode, cropId);


            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }





























    @GetMapping(value = "allMlogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringLogDto> getAllMlogs() {
        return monitoringLogServise.getAllMlogs(); // Use the injected service instance
    }



    @DeleteMapping("/{mCode}")
    public ResponseEntity<Void> deleteMlogs(@PathVariable ("mCode") String MCode) {
        try {
            monitoringLogServise.deleteMlogs(MCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PatchMapping(value = "/{updateMCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateMlogs(
            @PathVariable("updateMCode") String updateMCode,
            @RequestPart("mDate") String mDate,
            @RequestPart("observation") String observation,
            @RequestPart("observedImage") MultipartFile observedImage) {

        try {

            String toBase64FieldPic = AppUtil.toBase64FieldPic3(observedImage);

            MonitoringLogDto monitoringLogDto = new MonitoringLogDto();

            monitoringLogDto.setMCode(updateMCode);
            monitoringLogDto.setMDate(mDate);
            monitoringLogDto.setObservation(observation);
            monitoringLogDto.setObservedImage(toBase64FieldPic);

            monitoringLogServise.updateMlogs(monitoringLogDto);
            System.out.println("Endpoint hit with updateCode: " + updateMCode);


            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


















}
