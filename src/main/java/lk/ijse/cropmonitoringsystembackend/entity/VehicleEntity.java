package lk.ijse.cropmonitoringsystembackend.entity;


import jakarta.persistence.*;

import lk.ijse.cropmonitoringsystembackend.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehicle")
@Entity

public class VehicleEntity implements SuperEntity{

    @Id
    private String vehicleCode;
    @Column(nullable = false)
    private String licensePlateNo;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String fuelType;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String remark;
    @ManyToOne
    @JoinColumn(name = "assigned_staff_id")
    private StaffEntity staff;

}



//package lk.ijse.cropmonitoringsystembackend.entity;
//
//import jakarta.persistence.*;
//import lk.ijse.cropmonitoringsystembackend.enums.Status;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "vehicle")
//@Entity
//public class VehicleEntity implements SuperEntity {
//
//    @Id
//    private String vehicleCode;  // Primary Key
//
//    @Column(nullable = false)
//    private String licensePlateNo;  // Vehicle License Plate
//
//    @Column(nullable = false)
//    private String category;  // Category of the vehicle (e.g., truck, tractor)
//
//    @Column(nullable = false)
//    private String fuelType;  // Type of fuel used by the vehicle
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Status status;  // Status of the vehicle (e.g., ACTIVE, INACTIVE)
//
//    @Column(nullable = false)
//    private String remark;  // Additional remarks for the vehicle
//
//    // Foreign Key: Many-to-One relationship with StaffEntity (assigned_staff_id)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "assigned_staff_id", referencedColumnName = "id")
//    private StaffEntity staff;  // Staff assigned to the vehicle
//}
