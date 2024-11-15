package lk.ijse.cropmonitoringsystembackend.dao;


import lk.ijse.cropmonitoringsystembackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegDao extends JpaRepository<UserEntity,String> {

}
