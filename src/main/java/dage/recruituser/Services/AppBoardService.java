package dage.recruituser.Services;

import dage.recruituser.DAO.AppBoardDAO;
import dage.recruituser.DTO.AppBoardDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppBoardService {
    @Autowired
    AppBoardDAO appBoardDAO;

    public AppBoardDTO appBoardInfo(@Param("APP_NO") long app_no){
        return appBoardDAO.appBoardInfo(app_no);
    }
}
