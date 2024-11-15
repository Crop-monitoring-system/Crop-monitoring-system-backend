package lk.ijse.cropmonitoringsystembackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.cropmonitoringsystembackend.dao.UserRegDao;
import lk.ijse.cropmonitoringsystembackend.dto.UserRegDto;
import lk.ijse.cropmonitoringsystembackend.exception.UserNotFoundException;
import lk.ijse.cropmonitoringsystembackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserRegServiceIMPL implements UserRegService {

    @Autowired
    private final UserRegDao userRegDao;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveUser(UserRegDto userRegDto) {
        var userRegEntity = mapping.convertToUserEntity(userRegDto);
        var savedUser = userRegDao.save(userRegEntity);
        if (savedUser == null) {
            throw new UserNotFoundException("Cannot save user");
        }
    }
}
