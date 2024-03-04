package dage.recruituser.DAO;

import dage.recruituser.DTO.AppBoardDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppBoardDAO {
    AppBoardDTO appBoardInfo(@Param("APP_NO") long app_no);

    List<AppBoardDTO> annoList();

}
