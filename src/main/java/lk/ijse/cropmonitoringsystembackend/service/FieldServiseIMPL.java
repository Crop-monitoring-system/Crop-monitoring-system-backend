package lk.ijse.cropmonitoringsystembackend.service;


import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.FieldDao;
import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;

import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
import lk.ijse.cropmonitoringsystembackend.entity.StaffEntity;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor

public class FieldServiseIMPL implements FieldServise {

//    @Autowired
//    private final FieldDto fieldDto;

    @Autowired
    private final FieldDao fieldDao;

    @Autowired
    private final Mapping mapping;



    @Autowired
    private JdbcTemplate jdbcTemplate;  // JdbcTemplate for executing SQL queries




    @Override

    public String saveField(FieldDto fieldDto) {
        FieldEntity fieldEntity = mapping.convertToFieldEntity(fieldDto);

        // Manually assign the primary key if not set
        if (fieldEntity.getFCode() == null || fieldEntity.getFCode().isEmpty()) {
            fieldEntity.setFCode(UUID.randomUUID().toString()); // Generate a unique identifier
        }

        fieldDao.save(fieldEntity);
        return fieldEntity.getFCode(); // Return the generated/assigned fCode
    }




    @Override
    public List<FieldDto> getAllFields() {
        List<FieldEntity> getAllFields = fieldDao.findAll(); // Fetch all fields
        return mapping.convertFieldToDTOList(getAllFields);  // Convert entities to DTOs
    }

    @Override
    public void deleteFields(String fcode) {

        Optional<FieldEntity> selecteCode = fieldDao.findById(fcode);
        if(!selecteCode.isPresent()){
            throw new CropNotFoundException("Crop not found with code: " + fcode);
        }else {
            fieldDao.deleteById(fcode);
        }

    }



    @Override
    public void updateFields(FieldDto fieldDto) {

        System.out.println("Received Payload: " + fieldDto);
        // Save the FieldEntity, not CropEntity
        FieldEntity savedField = fieldDao.save(mapping.convertToFieldEntity(fieldDto)); // Convert to FieldEntity

        if (savedField == null) {
            throw new DataPersistFailedException("Cannot save data");
        }
    }







}

























//package lk.ijse.cropmonitoringsystembackend.service;
//
//
//import jakarta.transaction.Transactional;
//import lk.ijse.cropmonitoringsystembackend.dao.FieldDao;
//import lk.ijse.cropmonitoringsystembackend.dao.StaffDao;
//import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;
//
//import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
//import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
//import lk.ijse.cropmonitoringsystembackend.entity.StaffEntity;
//import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
//import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
//import lk.ijse.cropmonitoringsystembackend.util.Mapping;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//
//public class FieldServiseIMPL implements FieldServise {
//
////    @Autowired
////    private final FieldDto fieldDto;
//
//    @Autowired
//    private final FieldDao fieldDao;
//
//    @Autowired
//    private final Mapping mapping;
//
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate; // JdbcTemplate for executing SQL queries
//
//
//
//    @Autowired
//    private StaffDao staffDao;
//
//
//
//
//
//
//
//
//
//    @Override
//
//    public String saveField(FieldDto fieldDto) {
//        FieldEntity fieldEntity = mapping.convertToFieldEntity(fieldDto);
//
//        // Manually assign the primary key if not set
//        if (fieldEntity.getFCode() == null || fieldEntity.getFCode().isEmpty()) {
//            fieldEntity.setFCode(UUID.randomUUID().toString()); // Generate a unique identifier
//        }
//
//        fieldDao.save(fieldEntity);
//        return fieldEntity.getFCode(); // Return the generated/assigned fCode
//    }
//
//
//
//
//    @Override
//    public List<FieldDto> getAllFields() {
//        List<FieldEntity> getAllFields = fieldDao.findAll(); // Fetch all fields
//        return mapping.convertFieldToDTOList(getAllFields);  // Convert entities to DTOs
//    }
//
//    @Override
//    public void deleteFields(String fcode) {
//
//        Optional<FieldEntity> selecteCode = fieldDao.findById(fcode);
//        if(!selecteCode.isPresent()){
//            throw new CropNotFoundException("Crop not found with code: " + fcode);
//        }else {
//            fieldDao.deleteById(fcode);
//        }
//
//    }
//
//
//
//    @Override
//    public void updateFields(FieldDto fieldDto) {
//
//        System.out.println("Received Payload: " + fieldDto);
//        // Save the FieldEntity, not CropEntity
//        FieldEntity savedField = fieldDao.save(mapping.convertToFieldEntity(fieldDto)); // Convert to FieldEntity
//
//        if (savedField == null) {
//            throw new DataPersistFailedException("Cannot save data");
//        }
//    }
//
//
//
//
//
//
//
//    @Override
//    public void assignStaffToField(String fieldId, List<String> staffIds) {
//        // Check if the field exists using the repository
//        Optional<FieldEntity> fieldEntityOpt = fieldDao.findById(fieldId);
//        if (fieldEntityOpt.isPresent()) {
//            // Iterate over the staff IDs and insert each relationship into the `field_staff` table
//            for (String staffId : staffIds) {
//                // Check if the staff exists using the repository
//                Optional<StaffEntity> staffEntityOpt = staffDao.findById(staffId);
//                if (staffEntityOpt.isPresent()) {
//                    // Insert the relationship into the `field_staff` table using JdbcTemplate
//                    String sql = "INSERT INTO field_staff (field_id, staff_id) VALUES (?, ?)";
//                    jdbcTemplate.update(sql, fieldId, staffId);
//                } else {
//                    // If the staff does not exist, throw an exception
//                    throw new RuntimeException("Staff with ID " + staffId + " not found");
//                }
//            }
//        } else {
//            // If the field does not exist, throw an exception
//            throw new RuntimeException("Field with ID " + fieldId + " not found");
//        }
//    }
//
//
//}
