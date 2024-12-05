package lk.ijse.cropmonitoringsystembackend.service;


import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.FieldStaffDao;
import lk.ijse.cropmonitoringsystembackend.dao.LogFieldDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LogFieldServiseIMPL implements LogFieldServise {

    @Autowired
    private final LogFieldDao logFieldDao;


    @Override
    public void save(String mCode, String fielId) {
        logFieldDao.save(mCode, fielId);
    }
}
