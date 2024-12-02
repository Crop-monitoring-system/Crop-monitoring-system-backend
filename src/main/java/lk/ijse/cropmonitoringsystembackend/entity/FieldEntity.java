//package lk.ijse.cropmonitoringsystembackend.entity;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.geo.Point;
//import jakarta.persistence.*;
//
//import java.util.List;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "field")
//@Entity
//
//public class FieldEntity implements SuperEntity{
//
//    @Id
//    private String fCode;
//    @Column(length = 100, nullable = false, unique = true)
//    private String fieldName;
//    @Column(nullable = false)
//    private Double fieldSize;
//    @Column(nullable = false)
//    private Point fieldLocation;
////    @Column(nullable = false, columnDefinition = "LONGTEXT")
//    @Lob
//    private String fieldImage1;
//
////    @Column(nullable = false, columnDefinition = "LONGTEXT")
//
//    @Lob
//    private String fieldImage2;
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//
//    private AvailabilityStatus status;
//    @OneToMany(mappedBy = "field")
//    private List<CropEntity> crops;
//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "field_staff",
//            joinColumns = @JoinColumn(name = "field_id"),
//            inverseJoinColumns = @JoinColumn(name = "staff_id")
//    )
//    private List<StaffEntity> staffs;
//    @OneToMany(mappedBy = "field")
//    private List<EquipmentEntity> equipments;
//    @ManyToMany(mappedBy = "fields")
//    private List<MonitoringLogEntity> monitoringLogs;
//
//}





package lk.ijse.cropmonitoringsystembackend.entity;

import jakarta.persistence.*;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.geo.Point;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity implements SuperEntity {

    @Id
    private String fCode;


    @Column(nullable = false)
    private String fieldName;

    @Column(nullable = false)
    private String fieldSize;

    @Column(nullable = false)
    private String fieldLocation;

    @Lob
//    @Column(nullable = false)
    private String fieldImage1;


    @Lob
//    @Column(nullable = false)
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

