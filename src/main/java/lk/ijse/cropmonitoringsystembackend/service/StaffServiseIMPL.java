package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.FieldDao;
import lk.ijse.cropmonitoringsystembackend.dao.StaffDao;
import lk.ijse.cropmonitoringsystembackend.dto.StaffDto;
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
public class StaffServiseIMPL implements StaffServise {


    @Autowired
    private final FieldDao fieldDao;

    @Autowired
    private final Mapping mapping;
    @Autowired
    private StaffDao staffDao;


    @Override
    public String saveStaff(StaffDto staffDto) {

        StaffEntity staffEntity = mapping.convertToStaffEntity(staffDto);

        // Manually assign the primary key if not set
        if (staffEntity.getId() == null || staffEntity.getId().isEmpty()) {
            staffEntity.setId(UUID.randomUUID().toString()); // Generate a unique identifier
        }

        staffDao.save(staffEntity);
        return staffEntity.getId(); // Return the generated/assigned fCode
    }



    @Override
    public List<StaffDto> getAllStaff() {
        List<StaffEntity> getAllStaffs = staffDao.findAll(); // Fetch all fields
        return mapping.convertStaffToDTOList(getAllStaffs);
    }

    @Override
    public void deletestaff(String id) {
        Optional<StaffEntity> selecteId = staffDao.findById(id);
        if(!selecteId.isPresent()){
            throw new CropNotFoundException("Crop not found with code: " + id);
        }else {
            staffDao.deleteById(id);
        }
    }

    @Override
    public void updateStaff(StaffDto staffDto) {

        System.out.println("Received Payload: " + staffDto);
        // Save the FieldEntity, not CropEntity
        StaffEntity savedStaff = staffDao.save(mapping.convertToStaffEntity(staffDto)); // Convert to FieldEntity

        if (savedStaff == null) {
            throw new DataPersistFailedException("Cannot save data");
        }

    }
}
