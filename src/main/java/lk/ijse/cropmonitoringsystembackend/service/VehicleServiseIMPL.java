package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.EquipmentDao;
import lk.ijse.cropmonitoringsystembackend.dao.StaffDao;
import lk.ijse.cropmonitoringsystembackend.dao.VehicleDao;
import lk.ijse.cropmonitoringsystembackend.dto.VehicleDto;
import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.entity.StaffEntity;
import lk.ijse.cropmonitoringsystembackend.entity.VehicleEntity;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiseIMPL implements VehicleServise {


    @Autowired
    private final VehicleDao vehicleDao;


    @Autowired
    private final StaffDao staffDao;

    @Autowired
    private final Mapping mapping;


    @Override
    public void saveVehicle(VehicleDto vehicleDto) {

        System.out.println("Received Payload: " + vehicleDto);
        VehicleEntity saveVehicle = vehicleDao.save(mapping.convertToVehicalEntity(vehicleDto));
        if(saveVehicle == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }
}
