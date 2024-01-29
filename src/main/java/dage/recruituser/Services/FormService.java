package dage.recruituser.Services;

import dage.recruituser.DAO.UserInfoDAO;
import dage.recruituser.DTO.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserInfoService {

    @Autowired
    UserInfoDAO userInfoDAO;
    public UserInfoDTO userInfoSelect(@Param("USER_NO") Long user_no,
                                      Long user_app,
                                      String user_email,
                                      String user_password,
                                      String user_name,
                                      Date user_birth,
                                      String user_agree1,
                                      String user_agree2,
                                      String user_agree3,
                                      String user_agree4,
                                      String user_agree5,
                                      Date request_date,
                                      String user_gender,
                                      String user_nation,
                                      Long user_zip,
                                      String user_addr,
                                      String user_addr_dtl,
                                      String user_cp,
                                      String user_tel,
                                      String user_profile){
        return userInfoDAO.userInfoMapper(user_no,
                user_app,
                user_email,
                user_password,
                user_name,
                user_birth,
                user_agree1,
                user_agree2,
                user_agree3,
                user_agree4,
                user_agree5,
                request_date,
                user_gender,
                user_nation,
                user_zip,
                user_addr,
                user_addr_dtl,
                user_cp,
                user_tel,
                user_profile);
    }
}
