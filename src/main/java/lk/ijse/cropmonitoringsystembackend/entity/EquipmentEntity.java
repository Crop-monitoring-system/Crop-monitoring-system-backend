package lk.ijse.cropmonitoringsystembackend.entity;

import lk.ijse.cropmonitoringsystembackend.enums.Status;
import lk.ijse.cropmonitoringsystembackend.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "equipment")
@Entity

public class EquipmentEntity implements SuperEntity{

    @Id
    private String equipmentId;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_staff_id", referencedColumnName = "id")
    private StaffEntity staff;
    @ManyToOne
    @JoinColumn(name = "assigned_field_id")
    private FieldEntity field;

}
