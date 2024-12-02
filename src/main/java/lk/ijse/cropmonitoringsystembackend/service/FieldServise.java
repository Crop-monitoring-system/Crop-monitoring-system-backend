package lk.ijse.cropmonitoringsystembackend.service;

import lk.ijse.cropmonitoringsystembackend.dto.CropDto;
import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;

import java.util.List;

public interface FieldServise {
    String saveField(FieldDto fieldDto);

    List<FieldDto> getAllFields();
    void deleteFields(String fcode);

    void updateFields(FieldDto fieldDto);
}
