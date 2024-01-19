package dage.recruituser.DAO;

import dage.recruituser.DTO.CommCodeDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CommCodeDAO {
    public List<CommCodeDTO> selectCommCodeList(@Param("GRP_NAME") String GRP_NAME);
}
