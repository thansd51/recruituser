package dage.recruituser.DAO;

import dage.recruituser.DTO.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface FormDAO {

     /* 지원서 등록 */
     void appUserRegMapper(HashMap<String, String> map);

     /* 지원자 정보 */
     UserDTO appUser(@Param("form_no") long form_no);

     /* 지원서 미리보기 */
     List<AppFormDTO> appFormMapper(@Param("form_no") long form_no);

     /* 기본사항 - 조회 */
     InfoUserDTO infoUserMapper(@Param("FORM_NO") long form_no);
     InfoPersonDTO infoPersonMapper(@Param("FORM_NO") long form_no);

     /* 기본사항 - 저장 */
     void saveUserInfo(HashMap<String, String> map);
     void savePersonalInfo(HashMap<String, String> map);


     /* 학력사항 조회 - 고등학교 */
     InfoEduHighDTO eduHighMapper(@Param("FORM_NO") long form_no);
     /* 학력사항 조회 - 대학교 */
     List<InfoEduUnivDTO> eduUnivMapper(@Param("FORM_NO") long form_no, @Param("orderBy") String orderBy);

     /* 학력사항 - 고등학교 저장 */
     void saveEduHigh(HashMap<String, String> map);
     /* 학력사항 - 대학교 저장 */
     void saveEduUniv(HashMap<String, String> map);
     /* 학력사항 - 대학교 삭제 */
     void deleteEduUniv(@Param("FORM_NO") long form_no, @Param("UNIV_SEQ") long univ_seq);

     /* 경력사항 조회 */
     List<InfoCareerDTO> careerMapper(@Param("FORM_NO") long form_no);
     /* 경력사항 조회 - 프로젝트 */
     List<InfoProjectDTO> projectMapper(@Param("FORM_NO") long form_no);

     /* 경력사항 저장 */
     void saveCareer(HashMap<String, String> map);
     /* 경력사항 - 프로젝트 저장 */
     void saveProject(HashMap<String, String> map);

     /* 자격사항 조회 - 자격증 */
     List<InfoCertDTO> certMapper(@Param("FORM_NO") long form_no);
     /* 자격사항 조회 - 외국어 */
     List<InfoLangDTO> langMapper(@Param("FORM_NO") long form_no);
     /* 자격사항 조회 - OA */
     List<InfoOaDTO> OaMapper(@Param("FORM_NO") long form_no);

     /* 자격사항 저장 - 자격증 */
     void saveCert(HashMap<String, String> map);
     /* 자격사항 저장 - 외국어 */
     void saveLang(HashMap<String, String> map);
     /* 자격사항 저장 - OA */
     void saveOA(HashMap<String, String> map);

     /* 활동사항 조회 */
     List<InfoActDTO> actMapper(@Param("FORM_NO") long form_no);
     /* 활동사항 조회 - 수상내역 */
     List<InfoAwdDTO> awdMapper(@Param("FORM_NO") long form_no);

     /* 활동사항 저장 */
     void saveAct(HashMap<String, String> map);
     /* 활동사항 저장 - 수상내역 */
     void saveAwd(HashMap<String, String> map);

     /* 자기소개 조회 */
     List<InfoSurvDTO> survMapper(@Param("APP_NO") long app_no, @Param("FORM_NO") long form_no);

     /* 자기소개 저장*/
     void saveSurv(HashMap<String, String> map);

     /* 지원서 삭제 */
     void deleteUserForm(long form_no);

}
