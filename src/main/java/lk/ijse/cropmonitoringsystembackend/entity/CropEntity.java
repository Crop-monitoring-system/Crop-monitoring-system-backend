package lk.ijse.cropmonitoringsystembackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import jakarta.persistence.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crop")
@Entity
public class CropEntity implements SuperEntity{

    @Id
    private String cropCode;

    @Column(nullable = false)
    private String commonName;

    @Column(unique = true)
    private String scientificName;

    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String season;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

    @Lob
//    @Column(nullable = false)
    private String cropImage;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private FieldEntity field;

    @ManyToMany(mappedBy = "crops")
    private List<MonitoringLogEntity> monitoringLogs;

}


//
//package lk.ijse.cropmonitoringsystembackend.entity;
//
//import jakarta.persistence.*;
//import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "crop")
//public class CropEntity implements SuperEntity {
//
//    @Id
//    private String cropCode;
//
//    @Column(nullable = false)
//    private String commonName;
//
//    @Column(unique = true)
//    private String scientificName;
//
//    @Column(nullable = false)
//    private String category;
//
//    @Column(nullable = false)
//    private String season;
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private AvailabilityStatus status;
//
//    @Lob
//    private String cropImage;
//
//    // Many-to-One Relationship with FieldEntity
//    @ManyToOne
//    @JoinColumn(name = "field_id")  // This is the foreign key in the crop table referring to field_id
//    private FieldEntity field;
//
//    // Many-to-Many Relationship with MonitoringLogEntity
//    @ManyToMany(mappedBy = "crops")
//    private List<MonitoringLogEntity> monitoringLogs;
//
//}
//
