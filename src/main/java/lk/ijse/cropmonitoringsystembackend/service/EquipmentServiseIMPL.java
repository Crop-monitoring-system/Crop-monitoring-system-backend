package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.CropDao;
import lk.ijse.cropmonitoringsystembackend.dao.EquipmentDao;
import lk.ijse.cropmonitoringsystembackend.dao.FieldDao;
import lk.ijse.cropmonitoringsystembackend.dao.StaffDao;
import lk.ijse.cropmonitoringsystembackend.dto.EquipmentDto;
import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.entity.EquipmentEntity;
import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
import lk.ijse.cropmonitoringsystembackend.entity.StaffEntity;
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
public class EquipmentServiseIMPL implements EquipmentServise {

    @Autowired
    private final EquipmentDao equipmentDao;


    @Autowired
    private final StaffDao staffDao;

    @Autowired
    private final Mapping mapping;


    @Override
    public void saveEquipment(EquipmentDto equipmentDto) {
        System.out.println("Received Payload: " + equipmentDto);

        // Fetch the staff if assigned
//        if (equipmentDto.getAssignedStaffId() != null) {
        if (equipmentDto.getEId() != null) {
            StaffEntity staffEntity = staffDao.findById(equipmentDto.getAssignedStaffId())
                    .orElseThrow(() -> new RuntimeException("Staff not found"));

            if (staffEntity.getAddress() == null) {
                throw new DataPersistFailedException("Staff address cannot be null");
            }
        }

        // Save equipment
        EquipmentEntity saveEquipment = equipmentDao.save(mapping.convertToEquipmentEntity(equipmentDto));
        if (saveEquipment == null) {
            throw new DataPersistFailedException("Cannot save data");
        }
    }

    @Override
    public List<EquipmentDto> getAllequipment() {
        List<EquipmentEntity> getAllequipments = equipmentDao.findAll(); // Fetch all fields
        return mapping.convertEquipmentToDTOList(getAllequipments);
    }

    @Override
    public void deleteEquipment(String Eid) {

        Optional<EquipmentEntity> selecteCode = equipmentDao.findById(Eid);
        if(!selecteCode.isPresent()){
            throw new CropNotFoundException("equipment not found with code: " + Eid);
        }else {
            equipmentDao.deleteById(Eid);
        }
    }

    @Override
    public void updateEquipment(EquipmentDto equipmentDto) {
        System.out.println("Received Payload: " + equipmentDto);
        // Save the FieldEntity, not CropEntity
        EquipmentEntity savedEquipment = equipmentDao.save(mapping.convertToEquipmentEntity(equipmentDto)); // Convert to FieldEntity

        if (savedEquipment == null) {
            throw new DataPersistFailedException("Cannot save data");
        }
    }

}
