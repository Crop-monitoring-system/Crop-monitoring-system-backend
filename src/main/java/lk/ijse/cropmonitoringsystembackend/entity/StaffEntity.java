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
    private LocalDate dob;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private Designation designation;
    @Column(length = 20, nullable = false)
    private String role;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(length = 15, nullable = false)
    private String mobile;
    @Column(nullable = false)
    private String address;
    @Column(length = 10, nullable = false)
    private String postalCode;
    @CreationTimestamp
    private Timestamp joinedDate;
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private StaffStatus status;
    @ManyToMany(mappedBy = "staffs", fetch = FetchType.LAZY)
    private List<FieldEntity> fields;
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicles;
    @ManyToMany(mappedBy = "staffs", fetch = FetchType.LAZY)
    private List<MonitoringLogEntity> monitoringLogs;

}
