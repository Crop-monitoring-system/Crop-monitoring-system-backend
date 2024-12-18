package lk.ijse.cropmonitoringsystembackend.util;



import lk.ijse.cropmonitoringsystembackend.dao.EquipmentDao;
import lk.ijse.cropmonitoringsystembackend.dao.FieldDao;
import lk.ijse.cropmonitoringsystembackend.dao.StaffDao;
import lk.ijse.cropmonitoringsystembackend.dto.*;
import lk.ijse.cropmonitoringsystembackend.entity.*;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.enums.EquipmentType;
import lk.ijse.cropmonitoringsystembackend.enums.Status;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private FieldDao fieldDao;





    //User matters mapping

    public lk.ijse.cropmonitoringsystembackend.entity.UserEntity convertToUserEntity(UserRegDto userRegDto) {
        return modelMapper.map(userRegDto, UserEntity.class);
    }

    public List<UserRegDto> convertUserToDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserRegDto>>() {}.getType());
    }


//crop
    public CropEntity convertToCropEntity(CropDto cropDto) {
        return modelMapper.map(cropDto, CropEntity.class);
    }

    public CropDto convertToCropDTO(CropEntity cropEntity) {
        return modelMapper.map(cropEntity, CropDto.class);
    }


    public List<CropDto> convertCropToDTOList(List<CropEntity> cropEntities) {
        return modelMapper.map(cropEntities, new TypeToken<List<CropDto>>() {}.getType());
    }




//    field

    public FieldEntity convertToFieldEntity(FieldDto fieldDto) {
        return modelMapper.map(fieldDto, FieldEntity.class);
    }

    public FieldDto convertToFieldDTO(FieldEntity fieldEntity) {
        return modelMapper.map(fieldEntity, FieldDto.class);
    }


    public List<FieldDto> convertFieldToDTOList(List<FieldEntity> fieldEntities) {
        return modelMapper.map(fieldEntities, new TypeToken<List<FieldDto>>() {}.getType());
    }





    // staff

    public StaffEntity convertToStaffEntity(StaffDto staffDto) {
        return modelMapper.map(staffDto, StaffEntity.class);
    }

    public StaffDto convertToStaffDTO(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity, StaffDto.class);
    }


    public List<StaffDto> convertStaffToDTOList(List<StaffEntity> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDto>>() {}.getType());
    }











    //Equipment

//    public EquipmentEntity convertToEquipmentEntity(EquipmentDto equipmentDto) {
//        return modelMapper.map(equipmentDto, EquipmentEntity.class);
//    }


    public EquipmentEntity convertToEquipmentEntity(EquipmentDto equipmentDto) {
        EquipmentEntity equipmentEntity = new EquipmentEntity();
        equipmentEntity.setEquipmentId(equipmentDto.getEId());
        equipmentEntity.setName(equipmentDto.getName());
        equipmentEntity.setType(EquipmentType.valueOf(equipmentDto.getType()));
        equipmentEntity.setStatus(Status.valueOf(equipmentDto.getStatus()));

        if (equipmentDto.getAssignedStaffId() != null) {
            StaffEntity staff = staffDao.findById(equipmentDto.getAssignedStaffId())
                    .orElseThrow(() -> new RuntimeException("Staff not found"));
            equipmentEntity.setStaff(staff);
        }

        if (equipmentDto.getAssignedFieldId() != null) {
            FieldEntity field = fieldDao.findById(equipmentDto.getAssignedFieldId())
                    .orElseThrow(() -> new RuntimeException("Field not found"));
            equipmentEntity.setField(field);
        }
        return equipmentEntity;
    }


    public EquipmentDto convertToEquipmentDTO(EquipmentEntity equipmentEntity) {
        return modelMapper.map(equipmentEntity, EquipmentDto.class);
    }


//    public List<EquipmentDto> convertEquipmentToDTOList(List<EquipmentEntity> equipmentEntities) {
//        return modelMapper.map(equipmentEntities, new TypeToken<List<EquipmentDto>>() {}.getType());
//    }



    public List<EquipmentDto> convertEquipmentToDTOList(List<EquipmentEntity> equipmentEntities) {
        List<EquipmentDto> equipmentDtos = new ArrayList<>();

        for (EquipmentEntity equipmentEntity : equipmentEntities) {
            EquipmentDto equipmentDto = new EquipmentDto();

            // Map basic fields
            equipmentDto.setName(equipmentEntity.getName());

            // Convert Enums to String
            equipmentDto.setStatus(equipmentEntity.getStatus() != null ? equipmentEntity.getStatus().name() : null);
            equipmentDto.setType(equipmentEntity.getType() != null ? equipmentEntity.getType().name() : null);

            // Map related entities (Field and Staff) to IDs
            equipmentDto.setAssignedFieldId(equipmentEntity.getField() != null ? equipmentEntity.getField().getFCode() : null);
            equipmentDto.setAssignedStaffId(equipmentEntity.getStaff() != null ? equipmentEntity.getStaff().getId() : null);

            // Set equipment ID
            equipmentDto.setEId(equipmentEntity.getEquipmentId());

            equipmentDtos.add(equipmentDto);
        }

        return equipmentDtos;
    }



//    vehical



    public VehicleEntity convertToVehicalEntity(VehicleDto vehicleDto) {
        return modelMapper.map(vehicleDto, VehicleEntity.class);
    }

//    public StaffDto convertToStaffDTO(StaffEntity staffEntity) {
//        return modelMapper.map(staffEntity, StaffDto.class);
//    }
//
//



//    public List<VehicleDto> convertVehicalToDTOList(List<VehicleEntity> vehicleEntities) {
//        return modelMapper.map(vehicleEntities, new TypeToken<List<VehicleDto>>() {}.getType());
//    }




    public List<VehicleDto> convertVehicalToDTOList(List<VehicleEntity> vehicleEntities) {
        List<VehicleDto> vehicleDtos = new ArrayList<>();

        for (VehicleEntity vehicleEntity : vehicleEntities) {
            VehicleDto vehicleDto = new VehicleDto();

            // Map basic fields

            vehicleDto.setLicensePlateNo(vehicleEntity.getLicensePlateNo());

            // Convert Enums to String (if applicable)
            vehicleDto.setStatus(vehicleEntity.getStatus() != null ? vehicleEntity.getStatus().name() : null);
            vehicleDto.setFuelType(vehicleEntity.getFuelType() != null ? vehicleEntity.getFuelType().toString() : null);

            vehicleDto.setRemark(vehicleEntity.getRemark() != null ? vehicleEntity.getRemark().toString() : null);
            vehicleDto.setCategory(vehicleEntity.getCategory() != null ? vehicleEntity.getCategory().toString() : null);

            // Map related entities (Field and Staff) to IDs
            vehicleDto.setAssignedStaffId(vehicleEntity.getStaff() != null ? vehicleEntity.getStaff().getId() : null);


            // Set vehicle ID
            vehicleDto.setVCode(vehicleEntity.getVehicleCode());

            vehicleDtos.add(vehicleDto);
        }

        return vehicleDtos;
    }




    // mLogs

    public MonitoringLogEntity convertToMlogEntity(MonitoringLogDto monitoringLogDto) {
        return modelMapper.map(monitoringLogDto, MonitoringLogEntity.class);
    }

//    public StaffDto convertToStaffDTO(StaffEntity staffEntity) {
//        return modelMapper.map(staffEntity, StaffDto.class);
//    }


//    public List<MonitoringLogDto> convertMlogToDTOList(List<MonitoringLogEntity> monitoringLogEntities) {
//        return modelMapper.map(monitoringLogEntities, new TypeToken<List<MonitoringLogDto>>() {}.getType());
//    }


    public List<MonitoringLogDto> convertMlogToDTOList(List<MonitoringLogEntity> monitoringLogEntities) {
        List<MonitoringLogDto> monitoringLogDtos = new ArrayList<>();

        for (MonitoringLogEntity monitoringLogEntity : monitoringLogEntities) {
            MonitoringLogDto monitoringLogDto = new MonitoringLogDto();

            // Map basic fields
            monitoringLogDto.setMCode(monitoringLogEntity.getLogCode());
            monitoringLogDto.setMDate(monitoringLogEntity.getLogDate());
            monitoringLogDto.setObservation(monitoringLogEntity.getObservation());

            // Map the observed image (if applicable, e.g., Base64 or URL)
            monitoringLogDto.setObservedImage(monitoringLogEntity.getObservedImage());

            // If you have enums, convert them to String (e.g., status, type)
            if (monitoringLogEntity.getObservation() != null) {
                monitoringLogDto.setObservation(monitoringLogEntity.getObservation().toString());
            }



            monitoringLogDtos.add(monitoringLogDto);
        }

        return monitoringLogDtos;
    }



}























