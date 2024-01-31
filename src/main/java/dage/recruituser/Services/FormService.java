package dage.recruituser.Services;

import dage.recruituser.DAO.FormDAO;
import dage.recruituser.DTO.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FormService {

    @Autowired
    FormDAO formDAO;

    /* 기본사항 조회 */
    public InfoUserDTO userInfo(@Param("FORM_NO") long form_no) {
        return formDAO.infoUserMapper(form_no);
    }

    public InfoPersonDTO personInfo(@Param("FORM_NO") long form_no) {
        return formDAO.infoPersonMapper(form_no);
    }

    /* 학력사항 조회 */
    public InfoEduHighDTO eduHighInfo(@Param("FORM_NO") long form_no) {

        return formDAO.eduHighMapper(form_no);
    }

    public List<InfoEduUnivDTO> eduUnivInfo(@Param("FORM_NO") long form_no) {

        return formDAO.eduUnivMapper(form_no);
    }

    /* 지원서 등록 */
    public void appUserRegister(HashMap<String, String> map){
        formDAO.appUserRegMapper(map);
    }
    /* 기본사항 저장 */
    public void insertUserInfo(HashMap<String, String> map){
        formDAO.insertUserInfo(map);
    }
    public void insertPersonalInfo(HashMap<String, String> map){
        formDAO.insertPersonalInfo(map);
    }

    /* 학력사항 저장 */
    public void insertEduHigh(HashMap<String, String> map){
        formDAO.insertEduHigh(map);
    }
    public void insertEduUniv(HashMap<String, String> map){
        formDAO.insertEduUniv(map);
    }
}
