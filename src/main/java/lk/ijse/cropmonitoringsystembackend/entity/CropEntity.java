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
    @Column(nullable = false, unique = true)
    private String scientificName;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String season;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;
    @Lob
    @Column(nullable = false)
    private String cropImage;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private FieldEntity field;

    @ManyToMany(mappedBy = "crops")
    private List<MonitoringLogEntity> monitoringLogs;

}
