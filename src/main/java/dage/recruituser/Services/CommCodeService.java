package dage.recruituser.Services;

import dage.recruituser.DAO.CommCodeDAO;
import dage.recruituser.DTO.CommCodeDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommCodeService {
    @Autowired
    CommCodeDAO commCodeDAO;

    public List<CommCodeDTO> selectCommCodeList(@Param("GRP_NAME") String GRP_NAME){
        return commCodeDAO.selectCommCodeList(GRP_NAME);
    }
}
