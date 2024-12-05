package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.UserRegDao;
import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.entity.UserEntity;
import lk.ijse.cropmonitoringsystembackend.entity.VehicleEntity;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.exception.UserNotFoundException;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserRegServiceIMPL implements UserRegService {

    @Autowired
    private final UserRegDao userRegDao;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveUser(UserRegDto userRegDto) {

//        var userRegEntity = mapping.convertToUserEntity(userRegDto);
//        var savedUser = userRegDao.save(userRegEntity);
//        if (savedUser == null) {
//            throw new UserNotFoundException("Cannot save user");
//        }

        System.out.println("Received Payload: " + userRegDto);
        UserEntity saveUser = userRegDao.save(mapping.convertToUserEntity(userRegDto));
        if(saveUser == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }

    }



    @Override
    public List<UserRegDto> getAllUsers() {
        List<UserEntity> getAllUsers = userRegDao.findAll(); // Fetch all fields
        return mapping.convertUserToDTOList(getAllUsers);
    }

//    @Override
//    public UserDetailsService userDetailsService() {
//        return email ->
//                userRegDao.findByEmail(email)
//                        .orElseThrow(()-> new UserNotFoundException("User Not found"));
//                };
//    }


//
//    @Override
//    public boolean validateUser(String email, String password) {
//        UserEntity user = userRegDao.findByEmail(email).orElse(null); // Assume findByEmail is defined in UserRegDao
//        if (user != null && user.getPassword().equals(password)) { // Check password
//            return true; // Login success
//        }
//        return false; // Login failure
//    }



}
