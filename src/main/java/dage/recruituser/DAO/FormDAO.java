package dage.recruituser.DAO;

import dage.recruituser.DTO.FormInfoDTO;
import dage.recruituser.DTO.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FormDAO {
    public UserDTO userInfoMapper(String user_name, Date user_birth);

}
