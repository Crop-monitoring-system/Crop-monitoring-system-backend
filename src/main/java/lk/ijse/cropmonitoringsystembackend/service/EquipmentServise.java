package lk.ijse.cropmonitoringsystembackend.service;

import lk.ijse.cropmonitoringsystembackend.dto.CropDto;
import lk.ijse.cropmonitoringsystembackend.dto.EquipmentDto;
import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;

import java.util.List;

public interface EquipmentServise {

    void saveEquipment(EquipmentDto equipmentDto);

    List<EquipmentDto> getAllequipment();

    void deleteEquipment(String Eid);

    void updateEquipment(EquipmentDto equipmentDto);
}
