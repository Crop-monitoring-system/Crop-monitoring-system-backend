package lk.ijse.cropmonitoringsystembackend.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
@Entity

public class UserEntity implements SuperEntity{

    @Id
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;

}
