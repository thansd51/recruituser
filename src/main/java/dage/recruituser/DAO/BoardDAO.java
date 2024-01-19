package dage.recruituser.DAO;

import dage.recruituser.DTO.BoardDTO;
import dage.recruituser.DTO.CommCodeDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BoardDAO {
    List<BoardDTO> appForm(@Param("APP_NO") int app_no);

}
