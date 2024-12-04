package lk.ijse.cropmonitoringsystembackend.dao;

import lk.ijse.cropmonitoringsystembackend.entity.StaffEntity;
import lk.ijse.cropmonitoringsystembackend.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<StaffEntity,String> {



}
