package lk.ijse.cropmonitoringsystembackend.dao;

import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropDao extends JpaRepository<CropEntity,String> {
}
