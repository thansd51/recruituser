package dage.recruituser.Controller;

import dage.recruituser.DTO.CommCodeDTO;
import dage.recruituser.Services.CommCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class restController {

    @Autowired
    CommCodeService commCodeService;
    @RequestMapping("/select/{grp_name}")
    public List<CommCodeDTO> selectList(@PathVariable String grp_name){
        //List<CommCodeDTO> list = commCodeService.selectCommCodeList(grp_name);
        List<CommCodeDTO> list = commCodeService.selectCommCodeList(grp_name);
        return list;
    }
}
