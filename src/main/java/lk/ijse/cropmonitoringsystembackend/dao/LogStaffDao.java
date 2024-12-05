package lk.ijse.cropmonitoringsystembackend.dao;


import lk.ijse.cropmonitoringsystembackend.entity.MonitoringLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogStaffDao extends JpaRepository<MonitoringLogEntity, String > {

    @Modifying
    @Query(value = "INSERT INTO log_staff (log_id, staff_id) VALUES (:logId, :staffId)", nativeQuery = true)
    void save(String logId, String staffId);
}
