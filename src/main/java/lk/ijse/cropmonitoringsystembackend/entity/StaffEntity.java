package lk.ijse.cropmonitoringsystembackend.entity;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import lk.ijse.cropmonitoringsystembackend.enums.Gender;
import lk.ijse.cropmonitoringsystembackend.enums.Designation;
import lk.ijse.cropmonitoringsystembackend.enums.StaffStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "staff")
@Entity


public class StaffEntity implements SuperEntity{

    @Id
    private String id;
    @Column(length = 150, nullable = false)
    private String name;
    @Column(nullable = false)
    private String dob;
    @Column(length = 10)
//    @Enumerated(EnumType.STRING)
    private String  gender;
    @Column(length = 30, nullable = false)
//    @Enumerated(EnumType.STRING)
    private String designation;
    @Column(length = 20, nullable = false)
    private String role;
//    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String mobile;
//    @Column(nullable = false)
    private String address;
    @Column(length = 10, nullable = false)
    private String postalCode;
    @CreationTimestamp
    private Timestamp joinedDate;
    @Column(length = 10, nullable = false)
//    @Enumerated(EnumType.STRING)
    private String status;


    @ManyToMany(mappedBy = "staffs", fetch = FetchType.LAZY)
    private List<FieldEntity> fields;
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicles;
    @ManyToMany(mappedBy = "staffs", fetch = FetchType.LAZY)
    private List<MonitoringLogEntity> monitoringLogs;

}




//package lk.ijse.cropmonitoringsystembackend.entity;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import jakarta.persistence.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "staff")
//@Entity
//public class StaffEntity implements SuperEntity {
//
//    @Id
//    private String id;
//
//    @Column(length = 150, nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String dob;
//
//    @Column(length = 10)
//    private String gender;
//
//    @Column(length = 30, nullable = false)
//    private String designation;
//
//    @Column(length = 20, nullable = false)
//    private String role;
//
//    private String email;
//
//    @Column(length = 15, nullable = false)
//    private String mobile;
//
//    private String address;
//
//    @Column(length = 10, nullable = false)
//    private String postalCode;
//
//    @CreationTimestamp
//    private Timestamp joinedDate;
//
//    @Column(length = 10, nullable = false)
//    private String status;
//
//    // Foreign Key: Many-to-Many relationship with FieldEntity
//    @ManyToMany(mappedBy = "staffs", fetch = FetchType.LAZY)
//    private List<FieldEntity> fields;
//
//    // Foreign Key: One-to-Many relationship with VehicleEntity
//    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
//    private List<VehicleEntity> vehicles;
//
//    // Foreign Key: Many-to-Many relationship with MonitoringLogEntity
//    @ManyToMany(mappedBy = "staffs", fetch = FetchType.LAZY)
//    private List<MonitoringLogEntity> monitoringLogs;
//
//    // Foreign Key: Many-to-One relationship with FieldEntity (field_id)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "field_id", referencedColumnName = "fCode")
//    private FieldEntity field;  // Many staff members can be assigned to a field
//
//    // Foreign Key: Many-to-One relationship with VehicleEntity (vehicle_id)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleCode")
//    private VehicleEntity vehicle;  // Many staff members can be assigned to a vehicle
//}
//
