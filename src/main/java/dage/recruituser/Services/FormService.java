package dage.recruituser.Services;

import dage.recruituser.DAO.FormDAO;
import dage.recruituser.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FormService {

    @Autowired
    FormDAO formDAO;
    public UserDTO userInfoMapper(String user_name, Date user_birth){
        return formDAO.userInfoMapper(user_name, user_birth);
    }
}
