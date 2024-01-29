package dage.recruituser.DAO;

import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.DTO.EduHighDTO;
import dage.recruituser.DTO.EduUnivDTO;
import dage.recruituser.DTO.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface FormDAO {

     /* 기본사항 조회 */
     UserInfoDTO userInfo(@Param("USER_NO") long user_no);

     /* 학력사항 조회 - 고등학교 */
     EduHighDTO eduHighSelect(@Param("USER_NO") long user_no);

     /* 학력사항 조회 - 고등학교 */
     EduUnivDTO eduUnivSelect(@Param("USER_NO") long user_no);


     /* 지원서 등록 */
     void insertAppForm(HashMap<String, String> map);

     /* 기본정보 저장 */
     void insertUserInfo(HashMap<String, String> map);
     void insertPersonalInfo(HashMap<String, String> map);


     /* 학력사항 저장 */
     void insertEduHigh(HashMap<String, String> map);
     void insertEduUniv(HashMap<String, String> map);

     void deleteUserInfo(HashMap<String, String> map);

}
