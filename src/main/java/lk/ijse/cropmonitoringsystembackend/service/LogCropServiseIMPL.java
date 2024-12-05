package lk.ijse.cropmonitoringsystembackend.service;


import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.LogCropDao;
import lk.ijse.cropmonitoringsystembackend.dao.LogFieldDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LogCropServiseIMPL implements LogCropServise {

    @Autowired
    private final LogCropDao logCropDao;


    @Override
    public void save(String mCode, String cropId) {
        logCropDao.save(mCode, cropId);
    }
}
