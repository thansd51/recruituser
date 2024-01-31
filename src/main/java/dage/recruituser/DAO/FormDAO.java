package dage.recruituser.DAO;

import dage.recruituser.DTO.InfoEduHighDTO;
import dage.recruituser.DTO.InfoEduUnivDTO;
import dage.recruituser.DTO.InfoPersonDTO;
import dage.recruituser.DTO.InfoUserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface FormDAO {

     /* 기본사항 조회 */
     InfoUserDTO infoUserMapper(@Param("FORM_NO") long form_no);

     InfoPersonDTO infoPersonMapper(@Param("FORM_NO") long form_no);

     /* 학력사항 조회 - 고등학교 */
     InfoEduHighDTO eduHighMapper(@Param("FORM_NO") long form_no);

     /* 학력사항 조회 - 대학교 */
     List<InfoEduUnivDTO> eduUnivMapper(@Param("FORM_NO") long form_no);


     /* 지원서 등록 */
     void appUserRegMapper(HashMap<String, String> map);

     /* 기본정보 저장 */
     void insertUserInfo(HashMap<String, String> map);
     void insertPersonalInfo(HashMap<String, String> map);


     /* 학력사항 저장 */
     void insertEduHigh(HashMap<String, String> map);
     void insertEduUniv(HashMap<String, String> map);

     void deleteUserInfo(HashMap<String, String> map);

}
