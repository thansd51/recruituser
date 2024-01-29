package dage.recruituser.Services;

import dage.recruituser.DAO.FormDAO;
import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.DTO.EduHighDTO;
import dage.recruituser.DTO.EduUnivDTO;
import dage.recruituser.DTO.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormService {

    @Autowired
    FormDAO formDAO;

    /* 기본사항 조회 */
    public UserInfoDTO userInfo(@Param("USER_NO") long user_no) {

        System.out.println(formDAO.userInfo(user_no));
        return formDAO.userInfo(user_no);
    }

    public EduHighDTO eduHigh(@Param("USER_NO") long user_no) {

        System.out.println(formDAO.eduHighSelect(user_no));
        return formDAO.eduHighSelect(user_no);
    }

    public EduUnivDTO eduUniv(@Param("USER_NO") long user_no) {

        System.out.println(formDAO.eduUnivSelect(user_no));
        return formDAO.eduUnivSelect(user_no);
    }


    public void insertAppForm(HashMap<String, String> map){
        formDAO.insertAppForm(map);
    }
    public void insertUserInfo(HashMap<String, String> map){
        formDAO.insertUserInfo(map);
    }
    public void insertPersonalInfo(HashMap<String, String> map){
        formDAO.insertPersonalInfo(map);
    }
    public void insertEduHigh(HashMap<String, String> map){
        formDAO.insertEduHigh(map);
    }
}
