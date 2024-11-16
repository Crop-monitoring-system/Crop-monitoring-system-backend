package lk.ijse.cropmonitoringsystembackend.controller;


import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.exception.UserNotRegisteredException;
import lk.ijse.cropmonitoringsystembackend.service.UserRegService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/UserReg")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRegController {

    @Autowired
    private final UserRegService userRegService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserRegDto userRegDto) {
        if (userRegDto == null) {

            System.out.println("userRegDto is null");

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            userRegService.saveUser(userRegDto);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserNotRegisteredException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//
//    @GetMapping(value = "allUsers",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<UserRegDto> getAllUsers() {
//        return userRegService.getAllUsers();
//    }



}
