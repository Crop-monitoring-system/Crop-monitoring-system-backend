package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.MonitoringLogDao;
import lk.ijse.cropmonitoringsystembackend.dto.MonitoringLogDto;
import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
import lk.ijse.cropmonitoringsystembackend.entity.MonitoringLogEntity;
import lk.ijse.cropmonitoringsystembackend.entity.UserEntity;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class MonitoringLogServiseIMPL implements MonitoringLogServise {


    @Autowired
    private final Mapping mapping;

    @Autowired
    private final MonitoringLogDao monitoringLogDao;

    @Override
    public void saveMlog(MonitoringLogDto monitoringLogDto) {
        System.out.println("Received Payload: " + monitoringLogDto);
        MonitoringLogEntity saveMlogs = monitoringLogDao.save(mapping.convertToMlogEntity(monitoringLogDto));
        if(saveMlogs == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public List<MonitoringLogDto> getAllMlogs() {
        List<MonitoringLogEntity> getAllMlogss = monitoringLogDao.findAll(); // Fetch all fields
        return mapping.convertMlogToDTOList(getAllMlogss);
    }

    @Override
    public void deleteMlogs(String mCode) {
        Optional<MonitoringLogEntity> selecteCode = monitoringLogDao.findById(mCode);
        if(!selecteCode.isPresent()){
            throw new CropNotFoundException("Crop not found with code: " + mCode);
        }else {
            monitoringLogDao.deleteById(mCode);
        }
    }




    @Override
    public void updateMlogs(MonitoringLogDto monitoringLogDto) {


        System.out.println("Received Payload: " + monitoringLogDto);
        // Save the FieldEntity, not CropEntity
        MonitoringLogEntity savedMlogs = monitoringLogDao.save(mapping.convertToMlogEntity(monitoringLogDto)); // Convert to FieldEntity

        if (savedMlogs == null) {
            throw new DataPersistFailedException("Cannot save data");
        }
    }
}
