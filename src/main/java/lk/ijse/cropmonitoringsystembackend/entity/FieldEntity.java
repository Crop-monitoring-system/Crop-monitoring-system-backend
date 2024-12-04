package lk.ijse.cropmonitoringsystembackend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;
import jakarta.persistence.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "field")
@Entity

public class FieldEntity implements SuperEntity{

    @Id
    private String fCode;
    @Column(length = 100, nullable = false, unique = true)
    private String fieldName;
    @Column(nullable = false)
    private String fieldSize;
    @Column(nullable = false)
    private String fieldLocation;
//    @Column(nullable = false, columnDefinition = "LONGTEXT")
    @Lob
    private String fieldImage1;

//    @Column(nullable = false, columnDefinition = "LONGTEXT")

    @Lob
    private String fieldImage2;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)

    private AvailabilityStatus status;
    @OneToMany(mappedBy = "field")
    private List<CropEntity> crops;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "field_staff",
            joinColumns = @JoinColumn(name = "field_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<StaffEntity> staffs;
    @OneToMany(mappedBy = "field")
    private List<EquipmentEntity> equipments;
    @ManyToMany(mappedBy = "fields")
    private List<MonitoringLogEntity> monitoringLogs;

}





//
//
//package lk.ijse.cropmonitoringsystembackend.entity;
//
//import jakarta.persistence.*;
//import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GenericGenerator;
//import org.springframework.data.geo.Point;
//
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "field")
//public class FieldEntity implements SuperEntity {
//
//    @Id
//    private String fCode;
//
//
//    @Column(nullable = false)
//    private String fieldName;
//
//    @Column(nullable = false)
//    private String fieldSize;
//
//    @Column(nullable = false)
//    private String fieldLocation;
//
//    @Lob
////    @Column(nullable = false)
//    private String fieldImage1;
//
//
//    @Lob
////    @Column(nullable = false)
//    private String fieldImage2;
//
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private AvailabilityStatus status;
//
//    @OneToMany(mappedBy = "field")
//    private List<CropEntity> crops;
//
//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "field_staff",
//            joinColumns = @JoinColumn(name = "field_id"),
//            inverseJoinColumns = @JoinColumn(name = "staff_id")
//    )
//    private List<StaffEntity> staffs;
//
//    @OneToMany(mappedBy = "field")
//    private List<EquipmentEntity> equipments;
//
//    @ManyToMany(mappedBy = "fields")
//    private List<MonitoringLogEntity> monitoringLogs;
//}
//

















//package lk.ijse.cropmonitoringsystembackend.entity;
//
//import jakarta.persistence.*;
//import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.geo.Point;
//
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "field")
//public class FieldEntity implements SuperEntity {
//
//    @Id
//    private String fCode;
//
//    @Column(nullable = false, unique = true)
//    private String fieldName;
//
//    @Column(nullable = false)
//    private String fieldSize;
//
//    @Column(nullable = false)
//    private String fieldLocation;
//
//    @Lob
//    private String fieldImage1;
//
//    @Lob
//    private String fieldImage2;
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private AvailabilityStatus status;
//
//    // One-to-Many Relationship with CropEntity
//    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<CropEntity> crops;
//
//    // Many-to-Many Relationship with StaffEntity
//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "field_staff",
//            joinColumns = @JoinColumn(name = "field_id"),
//            inverseJoinColumns = @JoinColumn(name = "staff_id")
//    )
//    private List<StaffEntity> staffs;
//
//    // One-to-Many Relationship with EquipmentEntity
//    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<EquipmentEntity> equipments;
//
//    // Many-to-Many Relationship with MonitoringLogEntity
//    @ManyToMany(mappedBy = "fields", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<MonitoringLogEntity> monitoringLogs;
//
//    // One-to-One Relationship with StaffEntity for Assigned Staff (Foreign Key for Staff)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "assigned_staff_id", referencedColumnName = "id")  // Staff ID Foreign Key
//    private StaffEntity assignedStaff;
//
//    // One-to-One Relationship for Assigned Crop (Foreign Key for Crop)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "assigned_crop_id", referencedColumnName = "cropCode")  // Crop ID Foreign Key
//    private CropEntity assignedCrop;
//}
//
