package lk.ijse.cropmonitoringsystembackend.service;

import lk.ijse.cropmonitoringsystembackend.dto.FieldDto;
import lk.ijse.cropmonitoringsystembackend.dto.MonitoringLogDto;

import java.util.List;

public interface MonitoringLogServise {
    void saveMlog(MonitoringLogDto monitoringLogDto);

    List<MonitoringLogDto> getAllMlogs();
    void deleteMlogs(String mCode);

    void updateMlogs(MonitoringLogDto monitoringLogDto);
}
