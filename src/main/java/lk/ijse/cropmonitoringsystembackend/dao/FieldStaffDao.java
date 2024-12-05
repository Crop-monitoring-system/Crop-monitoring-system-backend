package lk.ijse.cropmonitoringsystembackend.dao;

import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldStaffDao extends JpaRepository<FieldEntity, String> {

    @Modifying
    @Query(value = "INSERT INTO field_staff (field_id, staff_id) VALUES (:fieldId, :staffId)", nativeQuery = true)
    void saveFieldStaff(String fieldId, String staffId);


    @Modifying
    @Query(value = "UPDATE field_staff SET staff_id = :staffId WHERE field_id = :fieldId", nativeQuery = true)
    void updateFieldStaff(String fieldId, String staffId);







}
