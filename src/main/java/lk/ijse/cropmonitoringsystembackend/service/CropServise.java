package lk.ijse.cropmonitoringsystembackend.service;

import lk.ijse.cropmonitoringsystembackend.dto.CropDto;

import java.util.List;

public interface CropServise {
    void saveCrops(CropDto cropDto);
    List<CropDto> getAllCrop();
    void deleteCrop(String cropCode);
}
