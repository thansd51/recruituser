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

    /* 지원서 등록 */
    public void appUserRegister(HashMap<String, String> map){
        formDAO.appUserRegMapper(map);
    }

    /* 기본사항 - 조회 */
    public List<AppFormDTO> previewAppForm(@Param("form_no") long form_no) {
        return formDAO.appFormMapper(form_no);
    }


    /* 기본사항 - 조회 */
    public UserDTO appUser(@Param("form_no") long form_no) {
        return formDAO.appUser(form_no);
    }


    /* 기본사항 - 조회 */
    public InfoUserDTO userInfo(@Param("FORM_NO") long form_no) {
        return formDAO.infoUserMapper(form_no);
    }
    /* 기본사항(신상정보) - 조회 */
    public InfoPersonDTO personInfo(@Param("FORM_NO") long form_no) {
        return formDAO.infoPersonMapper(form_no);
    }
    /* 기본사항 - 저장 */
    public void saveUserInfo(HashMap<String, String> map){
        formDAO.saveUserInfo(map);
    }
    /* 기본사항(신상정보) - 저장 */
    public void savePersonalInfo(HashMap<String, String> map){
        formDAO.savePersonalInfo(map);
    }


    /* 학력사항 조회 - 고등학교 */
    public InfoEduHighDTO eduHighInfo(@Param("FORM_NO") long form_no) {

        return formDAO.eduHighMapper(form_no);
    }
    /* 학력사항 조회 - 대학교 */
    public List<InfoEduUnivDTO> eduUnivInfo(@Param("FORM_NO") long form_no, @Param("orderBy") String orderBy) {

        return formDAO.eduUnivMapper(form_no, orderBy);
    }
    /* 학력사항 - 고등학교 저장 */
    public void saveEduHigh(HashMap<String, String> map){
        formDAO.saveEduHigh(map);
    }
    /* 학력사항 - 대학교 저장 */
    public void saveEduUniv(HashMap<String, String> map){
        formDAO.saveEduUniv(map);
    }
    /* 학력사항 - 대학교 삭제 */
    public void deleteEduUniv(@Param("FORM_NO") long form_no, @Param("UNIV_SEQ") long univ_seq){
        formDAO.deleteEduUniv(form_no, univ_seq);
    }


    /* 경력사항 조회 */
    public List<InfoCareerDTO> careerInfo(@Param("FORM_NO") long form_no) {

        return formDAO.careerMapper(form_no);
    }
    /* 경력사항 조회 - 프로젝트 */
    public List<InfoProjectDTO> projectInfo(@Param("FORM_NO") long form_no) {

        return formDAO.projectMapper(form_no);
    }

    /* 경력사항 저장 */
    public void saveCareer(HashMap<String, String> map){
        formDAO.saveCareer(map);
    }
    /* 경력사항 - 프로젝트 저장*/
    public void saveProject(HashMap<String, String> map){
        formDAO.saveProject(map);
    }


    /* 자격사항 조회 - 자격증 */
    public List<InfoCertDTO> certInfo(@Param("FORM_NO") long form_no) {

        return formDAO.certMapper(form_no);
    }
    /* 자격사항 조회 - 외국어 */
    public List<InfoLangDTO> langInfo(@Param("FORM_NO") long form_no) {

        return formDAO.langMapper(form_no);
    }
    /* 자격사항 조회 - OA */
    public List<InfoOaDTO> oaInfo(@Param("FORM_NO") long form_no) {

        return formDAO.OaMapper(form_no);
    }

    /* 자격사항 - 자격증 저장 */
    public void saveCert(HashMap<String, String> map){
        formDAO.saveCert(map);
    }
    /* 자격사항 - 외국어 저장 */
    public void saveLang(HashMap<String, String> map){
        formDAO.saveLang(map);
    }
    /* 자격사항 - OA 저장 */
    public void saveOA(HashMap<String, String> map){
        formDAO.saveOA(map);
    }


    /* 활동사항 조회 */
    public List<InfoActDTO> actInfo(@Param("FORM_NO") long form_no) {

        return formDAO.actMapper(form_no);
    }
    /* 활동사항 조회 - 수상내역 */
    public List<InfoAwdDTO> awdInfo(@Param("FORM_NO") long form_no) {

        return formDAO.awdMapper(form_no);
    }

    /* 활동사항 저장 */
    public void saveAct(HashMap<String, String> map){
        formDAO.saveAct(map);
    }
    /* 활동사항 저장 - 수상내역 */
    public void saveAwd(HashMap<String, String> map){
        formDAO.saveAwd(map);
    }


    /* 자기소개 조회 */
    public List<InfoSurvDTO> survInfo(@Param("APP_NO") long app_no, @Param("FORM_NO") long form_no) {

        return formDAO.survMapper(app_no, form_no);
    }
    /* 자기소개 저장 */
    public void saveSurv(HashMap<String, String> map){
        formDAO.saveSurv(map);
    }


    /* 지원서 삭제 */
    public void deleteUserForm(long form_no){
        formDAO.deleteUserForm(form_no);
    }
}
