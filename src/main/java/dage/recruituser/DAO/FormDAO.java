package dage.recruituser.DAO;

import dage.recruituser.DTO.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserInfoDAO {
    public UserInfoDTO userInfoMapper(@Param("USER_NO") Long userNo,
                                      Long userApp,
                                      String userEmail,
                                      String userPassword,
                                      String userName,
                                      Date userBirth,
                                      String userAgree1,
                                      String userAgree2,
                                      String userAgree3,
                                      String userAgree4,
                                      String userAgree5,
                                      Date requestDate,
                                      String userGender,
                                      String userNation,
                                      Long userZip,
                                      String userAddr,
                                      String userAddrDtl,
                                      String userCp,
                                      String userTel,
                                      String userProfile);

}
