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

    /* 기본사항 - 조회 */
    public InfoUserDTO userInfo(@Param("FORM_NO") long form_no) {
        return formDAO.infoUserMapper(form_no);
    }

    /* 기본사항(신상정보) - 조회 */
    public InfoPersonDTO personInfo(@Param("FORM_NO") long form_no) {
        return formDAO.infoPersonMapper(form_no);
    }

    /* 기본사항 - 저장 */
    public void insertUserInfo(HashMap<String, String> map){
        formDAO.insertUserInfo(map);
    }
    /* 기본사항(신상정보) - 저장 */
    public void insertPersonalInfo(HashMap<String, String> map){
        formDAO.insertPersonalInfo(map);
    }

    /* 기본사항 - 수정 */
    public void updateUserInfo(HashMap<String, String> map){
        formDAO.updateUserInfo(map);
    }

    /* 학력사항 조회 - 고등학교 */
    public InfoEduHighDTO eduHighInfo(@Param("FORM_NO") long form_no) {

        return formDAO.eduHighMapper(form_no);
    }

    /* 학력사항 조회 - 대학교 */
    public InfoEduUnivDTO eduUnivInfo(@Param("FORM_NO") long form_no) {

        return formDAO.eduUnivMapper(form_no);
    }

    /* 경력사항 조회 */
    public InfoCareerDTO careerInfo(@Param("FORM_NO") long form_no) {

        return formDAO.careerMapper(form_no);
    }

    /* 경력사항 조회 - 프로젝트 */
    public InfoProjectDTO projectInfo(@Param("FORM_NO") long form_no) {

        return formDAO.projectMapper(form_no);
    }

    /* 자격사항 조회 - 자격증 */
    public InfoCertDTO certInfo(@Param("FORM_NO") long form_no) {

        return formDAO.certMapper(form_no);
    }

    /* 자격사항 조회 - 외국어 */
    public InfoLangDTO langInfo(@Param("FORM_NO") long form_no) {

        return formDAO.langMapper(form_no);
    }

    /* 자격사항 조회 - OA */
    public InfoOaDTO oaInfo(@Param("FORM_NO") long form_no) {

        return formDAO.OaMapper(form_no);
    }

    /* 활동사항 조회 */
    public InfoActDTO actInfo(@Param("FORM_NO") long form_no) {

        return formDAO.actMapper(form_no);
    }

    /* 활동사항 조회 - 수상내역 */
    public InfoAwdDTO awdInfo(@Param("FORM_NO") long form_no) {

        return formDAO.awdMapper(form_no);
    }

    /* 활동사항 조회 - 수상내역 */
    public List<InfoSurvDTO> survInfo(@Param("APP_NO") long app_no, @Param("FORM_NO") long form_no) {

        return formDAO.survMapper(app_no, form_no);
    }

    /* 지원서 등록 */
    public void appUserRegister(HashMap<String, String> map){
        formDAO.appUserRegMapper(map);
    }



    /* 학력사항 - 고등학교 저장 */
    public void insertEduHigh(HashMap<String, String> map){
        formDAO.insertEduHigh(map);
    }
    /* 학력사항 - 대학교 저장 */
    public void insertEduUniv(HashMap<String, String> map){
        formDAO.insertEduUniv(map);
    }

    /* 경력사항 저장 */
    public void insertCareer(HashMap<String, String> map){
        formDAO.insertCareer(map);
    }
    /* 경력사항 - 프로젝트 저장*/
    public void insertProject(HashMap<String, String> map){
        formDAO.insertProject(map);
    }

    /* 자격사항 - 자격증 저장 */
    public void insertCert(HashMap<String, String> map){
        formDAO.insertCert(map);
    }
    /* 자격사항 - 외국어 저장 */
    public void insertLang(HashMap<String, String> map){
        formDAO.insertLang(map);
    }
    /* 자격사항 - OA 저장 */
    public void insertOA(HashMap<String, String> map){
        formDAO.insertOA(map);
    }

    /* 활동사항 저장 */
    public void insertAct(HashMap<String, String> map){
        formDAO.insertAct(map);
    }
    /* 활동사항 저장 - 수상내역 */
    public void insertAwd(HashMap<String, String> map){
        formDAO.insertAwd(map);
    }

    /* 자기소개 저장 */
    public void insertSurv(HashMap<String, String> map){
        formDAO.insertSurv(map);
    }

    /* 지원서 삭제 */
    public void deleteUserForm(long form_no){
        formDAO.deleteUserForm(form_no);
    }
}
