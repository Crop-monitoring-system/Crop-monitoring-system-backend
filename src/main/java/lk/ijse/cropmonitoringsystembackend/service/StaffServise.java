package lk.ijse.cropmonitoringsystembackend.service;

import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;
import lk.ijse.cropmonitoringsystembackend.dto.StaffDto;

import java.util.List;

public interface StaffServise {
     String saveStaff(StaffDto staffDto);

     List<StaffDto> getAllStaff();
     void deletestaff(String id);

     void updateStaff(StaffDto staffDto);
}
