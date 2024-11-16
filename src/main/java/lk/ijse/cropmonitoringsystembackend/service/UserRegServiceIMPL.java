package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.UserRegDao;
import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.entity.UserEntity;
import lk.ijse.cropmonitoringsystembackend.exception.UserNotFoundException;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        var userRegEntity = mapping.convertToUserEntity(userRegDto);
        var savedUser = userRegDao.save(userRegEntity);
        if (savedUser == null) {
            throw new UserNotFoundException("Cannot save user");
        }
    }



    @Override
    public List<UserRegDto> getAllUsers() {
        List<UserEntity> getAllUsers = userRegDao.findAll();
        long userCount = getAllUsers.size(); // Calculate the count from the fetched list
        System.out.println("Total number of users: " + userCount); // Print the count
        return mapping.convertUserToDTOList(getAllUsers); // Convert and return the user list
    }




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
