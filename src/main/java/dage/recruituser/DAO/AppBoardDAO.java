package dage.recruituser.DAO;

import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.DTO.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppBoardDAO {
    AppBoardDTO appBoardInfo(@Param("APP_NO") long app_no);


}
