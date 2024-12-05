package lk.ijse.cropmonitoringsystembackend.service;

import lk.ijse.cropmonitoringsystembackend.dto.EquipmentDto;
import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.dto.VehicleDto;

import java.util.List;

public interface VehicleServise {

    void saveVehicle(VehicleDto vehicleDto);


    List<VehicleDto> getAllVehicals();

    void deleteVehical(String vCode);

    void updatevehicle(VehicleDto vehicleDto);
}
