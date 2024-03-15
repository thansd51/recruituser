package dage.recruituser.Services;

import dage.recruituser.DAO.AppBoardDAO;
import dage.recruituser.DTO.AppBoardDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AppBoardService {
    @Autowired
    AppBoardDAO appBoardDAO;


    public AppBoardDTO selectAppBoardInfo(@Param("app_no") long app_no){
        return appBoardDAO.selectAppBoardInfo(app_no);
    }

    public List<AppBoardDTO> selectAllAppBoardInfo(){
        return appBoardDAO.selectAppBoardInfo();
    }

    // 공고 등록
    public void appRegister(HashMap<String, String> map){
        appBoardDAO.appRegister(map);
    }

    // 공고 수정
    public void appUpdate(HashMap<String, String> map){
        appBoardDAO.appUpdate(map);
    }

    // 공고 수정
    public void appDelete(long app_no){
        appBoardDAO.appDelete(app_no);
    }
}
