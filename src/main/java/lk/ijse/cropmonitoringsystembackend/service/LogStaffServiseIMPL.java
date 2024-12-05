package lk.ijse.cropmonitoringsystembackend.service;


import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.LogFieldDao;
import lk.ijse.cropmonitoringsystembackend.dao.LogStaffDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LogStaffServiseIMPL implements LogStaffServise {

    @Autowired
    private final LogStaffDao logStaffDao;

    @Override
    public void save(String mCode, String staffid) {
        logStaffDao.save(mCode, staffid);
    }
}
