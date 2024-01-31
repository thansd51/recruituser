package dage.recruituser.api;

import dage.recruituser.DTO.CommCodeDTO;
import dage.recruituser.Services.CommCodeService;
import dage.recruituser.Services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestAPI {

    @Autowired
    CommCodeService commCodeService;

    @Autowired
    FormService formService;

    @RequestMapping("/select/{grp_name}")
    public List<CommCodeDTO> selectList(@PathVariable String grp_name) {
        List<CommCodeDTO> list = commCodeService.selectCommCodeList(grp_name);

//        System.out.println(list);
        return list;
    }

    @RequestMapping("/appUser")
    public String appUserRegister(HttpServletRequest request, Model model, HttpSession session) {
        System.out.println("form_no");
        HashMap<String, String> AppUser = new HashMap<>();

        AppUser.put("app_no", request.getParameter("app_no"));
        AppUser.put("user_email", request.getParameter("user_email"));
        AppUser.put("user_password", request.getParameter("user_password"));
        AppUser.put("user_name", request.getParameter("user_name"));
        AppUser.put("user_birth", request.getParameter("user_birth"));
        AppUser.put("user_agree_1", request.getParameter("user_agree_1"));
        AppUser.put("user_agree_2", request.getParameter("user_agree_2"));
        AppUser.put("user_agree_3", request.getParameter("user_agree_3"));
        AppUser.put("user_agree_4", request.getParameter("user_agree_4"));
        AppUser.put("user_agree_5", request.getParameter("user_agree_5"));

        formService.appUserRegister(AppUser);

        String form_no = String.valueOf(AppUser.get("form_no")) ;

        return form_no;
    }

    @RequestMapping("/infoUser")
    public String userInfoSave(HttpServletRequest request) {

        HashMap<String, String> infoUser = new HashMap<>();

        infoUser.put("form_no", request.getParameter("form_no"));
        infoUser.put("request_date", request.getParameter("request_date"));
        infoUser.put("user_gender", request.getParameter("user_gender"));
        infoUser.put("user_nation", request.getParameter("user_nation"));
        infoUser.put("user_zip", request.getParameter("user_zip"));
        infoUser.put("user_address", request.getParameter("user_address"));
        infoUser.put("user_address_dtl", request.getParameter("user_address_dtl"));
        infoUser.put("user_cp", request.getParameter("user_cp"));
        infoUser.put("user_tel", request.getParameter("user_tel"));
        infoUser.put("user_profile", request.getParameter("user_profile"));

        formService.insertUserInfo(infoUser);

        HashMap<String, String> infoPerson = new HashMap<>();

        infoPerson.put("form_no", request.getParameter("form_no"));
        infoPerson.put("mil_srvc", request.getParameter("mil_srvc"));
        infoPerson.put("mil_type", request.getParameter("mil_type"));
        infoPerson.put("mil_type_dtl", request.getParameter("mil_type_dtl"));
        infoPerson.put("mil_discharge", request.getParameter("mil_discharge"));
        infoPerson.put("mil_exem", request.getParameter("mil_exem"));
        infoPerson.put("mil_start_date", request.getParameter("mil_start_date"));
        infoPerson.put("mil_end_date", request.getParameter("mil_end_date"));
        infoPerson.put("vtr_srvc", request.getParameter("vtr_srvc"));
        infoPerson.put("vtr_relation", request.getParameter("vtr_relation"));
        infoPerson.put("vtr_num", request.getParameter("vtr_num"));
        infoPerson.put("dis_srvc", request.getParameter("dis_srvc"));
        infoPerson.put("dis_class", request.getParameter("dis_class"));
        infoPerson.put("dis_rate", request.getParameter("dis_rate"));

        formService.insertPersonalInfo(infoPerson);

        String form_no = String.valueOf(infoUser.get("form_no")) ;

        return form_no;
    }

    @RequestMapping("/infoEdu")
    public String eduHighSave(HttpServletRequest request) {

        HashMap<String, String> eduHighMap = new HashMap<>();

        eduHighMap.put("form_no", request.getParameter("form_no"));
        eduHighMap.put("high_name", request.getParameter("high_name"));
        eduHighMap.put("high_loc", request.getParameter("high_loc"));
        eduHighMap.put("high_ser", request.getParameter("high_ser"));
        eduHighMap.put("high_grd", request.getParameter("high_grd"));
        eduHighMap.put("high_start_date", request.getParameter("high_start_date"));
        eduHighMap.put("high_end_date", request.getParameter("high_end_date"));
        eduHighMap.put("high_fn", request.getParameter("high_fn"));

        formService.insertEduHigh(eduHighMap);


//        for(Map.Entry<String, String> eduUnivMap : )
//        formService.insertEduUniv(eduUnivMap);


        return "userForm/edu_info";
    }
}
