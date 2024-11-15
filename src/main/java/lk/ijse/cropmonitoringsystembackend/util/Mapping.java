package lk.ijse.cropmonitoringsystembackend.util;



import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    //User matters mapping
    public lk.ijse.cropmonitoringsystembackend.entity.UserEntity convertToUserEntity(UserRegDto userRegDto) {
        return modelMapper.map(userRegDto, UserEntity.class);
    }

//    public UserRegDto convertToUserDTO(UserEntity userEntity) {
//        return modelMapper.map(userEntity, UserRegDto.class);
//    }


}
