package lk.ijse.cropmonitoringsystembackend.service;


import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.FieldStaffDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class Field_staffServiseIMPL implements Field_staffServise {

    private final FieldStaffDao fieldStaffDao;

    @Override
    public void saveFieldStaff(String fcode, String staffId) {
        // Directly insert into the field_staff table
        fieldStaffDao.saveFieldStaff(fcode, staffId);
    }

    @Override
    public void updateFieldStaff(String fcode, String staffId) {
        fieldStaffDao.updateFieldStaff(fcode, staffId);
    }
}
