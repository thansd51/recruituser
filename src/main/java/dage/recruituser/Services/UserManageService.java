package dage.recruituser.Services;

import dage.recruituser.DAO.AppBoardDAO;
import dage.recruituser.DAO.UserManageDAO;
import dage.recruituser.DTO.AppBoardDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserManageService {

    @Autowired
    UserManageDAO userManageDAO;

    /* 전체 지원자 조회 */
    public List<HashMap<String, Object>> appInfoList(@Param("app_no") long app_no, @Param("proc_seq") long proc_seq){
        return userManageDAO.selectAppInfo(app_no, proc_seq);
    }

//    public List<HashMap<String, Object>> allAppList(){
//        return userManageDAO.selectAppInfo();
//    }



    public void procUpdate(HashMap<String, Object> map){
        userManageDAO.procUpdate(map);
    }

    /* 공고별 지원자 조회 */
//    public HashMap<String, Object> selectAppInfo(@Param("app_no") long app_no){
//        return userManageDAO.selectAppInfo(app_no);
//    }



}
