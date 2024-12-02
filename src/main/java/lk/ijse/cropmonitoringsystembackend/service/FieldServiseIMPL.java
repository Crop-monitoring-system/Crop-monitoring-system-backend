package lk.ijse.cropmonitoringsystembackend.service;


import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.FieldDao;
import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;

import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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


//    @Override
//    public void saveField(FieldDto fieldDto) {
//        System.out.println("Received Payload: " + fieldDto);
//        FieldEntity saveField = fieldDao.save(mapping.convertToFieldEntity(fieldDto));
//        if (saveField == null) {
//            throw new DataPersistFailedException("Cannot save data");
//        }
//    }



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
