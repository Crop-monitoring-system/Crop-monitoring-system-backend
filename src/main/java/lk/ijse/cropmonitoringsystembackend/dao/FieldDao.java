package lk.ijse.cropmonitoringsystembackend.dao;

import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldDao extends JpaRepository<FieldEntity,String> {
}
