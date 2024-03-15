package dage.recruituser.DAO;

import dage.recruituser.DTO.AppBoardDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AppBoardDAO {
    // 선택 공고 상세 조회
    AppBoardDTO selectAppBoardInfo(@Param("app_no") long app_no);

    // 전체 공고 목록
    List<AppBoardDTO> selectAppBoardInfo();

    // 공고 등록
    void appRegister(HashMap<String, String> map);

    // 공고 수정
    void appUpdate(HashMap<String, String> map);

    // 공고 삭제
    void appDelete(long app_no);

}
