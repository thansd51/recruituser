package dage.recruituser.DAO;

import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.DTO.CommCodeDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CommCodeDAO {
     List<CommCodeDTO> selectCommCodeList(@Param("GRP_NAME") String GRP_NAME);

     List<AppBoardDTO> selectAppList(@Param("APP_NO") long app_no);
}
