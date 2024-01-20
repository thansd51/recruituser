package dage.recruituser.api;

import dage.recruituser.DTO.CommCodeDTO;
import dage.recruituser.Services.CommCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAPI {

    @Autowired
    CommCodeService commCodeService;
    @RequestMapping("/select/{grp_name}")
    public List<CommCodeDTO> selectList(@PathVariable String grp_name){
        //List<CommCodeDTO> list = commCodeService.selectCommCodeList(grp_name);
        List<CommCodeDTO> list = commCodeService.selectCommCodeList(grp_name);

        return list;
    }
}
