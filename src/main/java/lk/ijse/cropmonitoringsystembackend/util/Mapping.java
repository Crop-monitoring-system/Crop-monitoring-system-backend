package lk.ijse.cropmonitoringsystembackend.util;



import lk.ijse.cropmonitoringsystembackend.dto.CropDto;
import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    //User matters mapping
    public lk.ijse.cropmonitoringsystembackend.entity.UserEntity convertToUserEntity(UserRegDto userRegDto) {
        return modelMapper.map(userRegDto, UserEntity.class);
    }




    public List<UserRegDto> convertUserToDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserRegDto>>() {}.getType());
    }



    public CropEntity convertToCropEntity(CropDto cropDto) {
        return modelMapper.map(cropDto, CropEntity.class);
    }

    public CropDto convertToCropDTO(CropEntity cropEntity) {
        return modelMapper.map(cropEntity, CropDto.class);
    }



}
