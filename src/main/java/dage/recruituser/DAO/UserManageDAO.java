package dage.recruituser.DAO;

import dage.recruituser.DTO.AppBoardDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserManageDAO {
    /* 전체 지원자 조회 */
    List<HashMap<String, Object>> selectAppInfo(@Param("app_no") long app_no, @Param("proc_seq") long proc_seq);

//    List<HashMap<String, Object>> selectAppInfo();

    void procUpdate(HashMap<String, Object> map);

    /* 공고별 지원자 조회 */
//    HashMap<String, Object> selectAppInfo(@Param("app_no") long app_no);


}
