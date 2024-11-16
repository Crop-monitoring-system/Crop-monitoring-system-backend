//package lk.ijse.cropmonitoringsystembackend.controller;
//
//import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
//import lk.ijse.cropmonitoringsystembackend.service.UserRegService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.Map;
//
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("api/v1")
//@RequiredArgsConstructor
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class LoginController {
//
//
//    @Autowired
//    private final UserRegService userRegService;
//
//    @GetMapping(value = "allUsers",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<UserRegDto> getAllUsers() {
//        return userRegService.getAllUsers();
//    }
//
//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData) {
//        String email = loginData.get("email");
//        String password = loginData.get("password");
//
//        boolean isValid = userRegService.validateUser(email, password);
//        if (isValid) {
//            return ResponseEntity.ok(Map.of("success", true, "message", "Login successful!"));
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("success", false, "message", "Invalid email or password."));
//        }
//    }
//
//
//
//}
