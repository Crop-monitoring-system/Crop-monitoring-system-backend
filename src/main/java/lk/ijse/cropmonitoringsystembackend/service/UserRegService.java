package lk.ijse.cropmonitoringsystembackend.service;

import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserRegService {
    void saveUser(UserRegDto userRegDto);
    List<UserRegDto> getAllUsers();
//    boolean validateUser(String email, String password);



}
