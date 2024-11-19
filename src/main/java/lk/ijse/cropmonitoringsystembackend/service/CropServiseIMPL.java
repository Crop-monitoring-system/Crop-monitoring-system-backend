package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.CropDao;
import lk.ijse.cropmonitoringsystembackend.dao.FieldDao;
import lk.ijse.cropmonitoringsystembackend.dto.CropDto;
import lk.ijse.cropmonitoringsystembackend.entity.CropEntity;
import lk.ijse.cropmonitoringsystembackend.entity.FieldEntity;
import lk.ijse.cropmonitoringsystembackend.enums.AvailabilityStatus;
import lk.ijse.cropmonitoringsystembackend.exception.CropNotFoundException;
import lk.ijse.cropmonitoringsystembackend.exception.DataPersistFailedException;
import lk.ijse.cropmonitoringsystembackend.exception.FieldNotFoundException;
import lk.ijse.cropmonitoringsystembackend.util.AppUtil;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CropServiseIMPL implements CropServise {

    @Autowired
    private final CropDao cropDao;

    @Autowired
    private final FieldDao fieldDao;

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

    @Override
    public List<CropDto> getAllCrop() {
        List<CropEntity> getAllCrops = cropDao.findAll();
        return mapping.convertCropToDTOList(getAllCrops);
    }

    @Override
    public void deleteCrop(String cropCode) {
        Optional<CropEntity> selecteCode = cropDao.findById(cropCode);
        if(!selecteCode.isPresent()){
            throw new CropNotFoundException("Crop not found with code: " + cropCode);
        }else {
            cropDao.deleteById(cropCode);
        }
    }



    @Override
    public void updateCrop(CropDto cropDto) {
//        Optional<CropEntity> tmpCrop = cropDao.findById(cropDto.getCode());
//        if(!tmpCrop.isPresent()){
//            throw new CropNotFoundException("Crop not found");
//        } else {
//            System.out.println("Received Payload: " + cropDto);
//            CropEntity saveCrops = cropDao.save(mapping.convertToCropEntity(cropDto));
//            if(saveCrops == null ) {
//                throw new DataPersistFailedException("Cannot data saved");
//            }
//
//        }

        System.out.println("Received Payload: " + cropDto);
        CropEntity saveCrops = cropDao.save(mapping.convertToCropEntity(cropDto));
        if(saveCrops == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }


    }


}
