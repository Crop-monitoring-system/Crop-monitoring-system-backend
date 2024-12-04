package lk.ijse.cropmonitoringsystembackend.dao;

import lk.ijse.cropmonitoringsystembackend.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<VehicleEntity,String> {
}
