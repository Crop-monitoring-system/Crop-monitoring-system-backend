package lk.ijse.cropmonitoringsystembackend.dao;

import lk.ijse.cropmonitoringsystembackend.dto.MonitoringLogDto;
import lk.ijse.cropmonitoringsystembackend.entity.MonitoringLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LogFieldDao extends JpaRepository<MonitoringLogEntity,String > {

    @Modifying
    @Query(value = "INSERT INTO log_field (log_id, field_id) VALUES (:logId, :fieldId)", nativeQuery = true)
    void save(String logId, String fieldId);

}
