package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.CropDao;
import lk.ijse.cropmonitoringsystembackend.dto.CropDto;
import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.util.AppUtil;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class CropServiseIMPL implements CropServise {

    @Autowired
    private final CropDao cropDao;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveCrops(CropDto cropDto) {
//        cropDto.setCode(AppUtil.createCropId());
        System.out.println("Received Payload: " + cropDto);
        CropEntity saveCrops = cropDao.save(mapping.convertToCropEntity(cropDto));
        if(saveCrops == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

}
