package dage.recruituser.DAO;

import dage.recruituser.DTO.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface FormDAO {

     /* 기본사항 - 조회 */
     InfoUserDTO infoUserMapper(@Param("FORM_NO") long form_no);
     InfoPersonDTO infoPersonMapper(@Param("FORM_NO") long form_no);

     /* 기본사항 - 저장 */
     void insertUserInfo(HashMap<String, String> map);
     void insertPersonalInfo(HashMap<String, String> map);

     /* 기본사항 - 수정 */
     void updateUserInfo(HashMap<String, String> map);






     /* 학력사항 조회 - 고등학교 */
     InfoEduHighDTO eduHighMapper(@Param("FORM_NO") long form_no);

     /* 학력사항 조회 - 대학교 */
     InfoEduUnivDTO eduUnivMapper(@Param("FORM_NO") long form_no);

     /* 경력사항 조회 */
     InfoCareerDTO careerMapper(@Param("FORM_NO") long form_no);

     /* 경력사항 조회 - 프로젝트 */
     InfoProjectDTO projectMapper(@Param("FORM_NO") long form_no);

     /* 자격사항 조회 - 자격증 */
     InfoCertDTO certMapper(@Param("FORM_NO") long form_no);

     /* 자격사항 조회 - 외국어 */
     InfoLangDTO langMapper(@Param("FORM_NO") long form_no);

     /* 자격사항 조회 - OA */
     InfoOaDTO OaMapper(@Param("FORM_NO") long form_no);

     /* 활동사항 조회 */
     InfoActDTO actMapper(@Param("FORM_NO") long form_no);

     /* 활동사항 조회 - 수상내역 */
     InfoAwdDTO awdMapper(@Param("FORM_NO") long form_no);

     /* 자기소개 조회 */
     List<InfoSurvDTO> survMapper(@Param("APP_NO") long app_no, @Param("FORM_NO") long form_no);


     /* 지원서 등록 */
     void appUserRegMapper(HashMap<String, String> map);

     /* 학력사항 - 고등학교 저장 */
     void insertEduHigh(HashMap<String, String> map);
     /* 학력사항 - 대학교 저장 */
     void insertEduUniv(HashMap<String, String> map);

     /* 경력사항 저장 */
     void insertCareer(HashMap<String, String> map);
     /* 경력사항 - 프로젝트 저장 */
     void insertProject(HashMap<String, String> map);

     /* 자격사항 저장 - 자격증 */
     void insertCert(HashMap<String, String> map);
     /* 자격사항 저장 - 외국어 */
     void insertLang(HashMap<String, String> map);
     /* 자격사항 저장 - OA */
     void insertOA(HashMap<String, String> map);

     /* 활동사항 저장 */
     void insertAct(HashMap<String, String> map);
     /* 활동사항 저장 - 수상내역 */
     void insertAwd(HashMap<String, String> map);

     /* 활동사항 저장 - 수상내역 */
     void insertSurv(HashMap<String, String> map);

     /* 지원서 삭제 */
     void deleteUserForm(long form_no);

}
