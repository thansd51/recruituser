package dage.recruituser.api;

import dage.recruituser.DTO.CommCodeDTO;
import dage.recruituser.DTO.UserInfoDTO;
import dage.recruituser.Services.CommCodeService;
import dage.recruituser.Services.FormService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("/appForm")
    public String appFormSave(HttpServletRequest request, Model model, HttpSession session) {

        HashMap<String, String> insertAppFormMap = new HashMap<>();

        insertAppFormMap.put("app_no", request.getParameter("app_no"));
        insertAppFormMap.put("user_email", request.getParameter("user_email"));
        insertAppFormMap.put("user_password", request.getParameter("user_password"));
        insertAppFormMap.put("user_name", request.getParameter("user_name"));
        insertAppFormMap.put("user_birth", request.getParameter("user_birth"));
        insertAppFormMap.put("user_agree_1", request.getParameter("user_agree_1"));
        insertAppFormMap.put("user_agree_2", request.getParameter("user_agree_2"));
        insertAppFormMap.put("user_agree_3", request.getParameter("user_agree_3"));
        insertAppFormMap.put("user_agree_4", request.getParameter("user_agree_4"));
        insertAppFormMap.put("user_agree_5", request.getParameter("user_agree_5"));

        formService.insertAppForm(insertAppFormMap);
//        System.out.println(insertAppFormMap);
//
//        model.addAttribute("insertAppFormMap", insertAppFormMap);
//        System.out.println(model.addAttribute("insertAppFormMap", insertAppFormMap));

//        String user_no = String.valueOf(insertAppFormMap.get("user_no"));
//
//        insertAppFormMap.put("user_no", user_no);
//        System.out.println(insertAppFormMap.put("user_no", user_no));
//
//        model.addAttribute("insert", insertAppFormMap);
//
//        System.out.println(model.addAttribute("insertAppFormMap", insertAppFormMap));
        return "userForm/app_form";
    }

    @RequestMapping("/userInfo")
    public String userInfoSave(HttpServletRequest request) {

        HashMap<String, String> userInfoMap = new HashMap<>();

        userInfoMap.put("user_no", request.getParameter("user_no"));
        userInfoMap.put("request_date", request.getParameter("request_date"));
        userInfoMap.put("user_gender", request.getParameter("user_gender"));
        userInfoMap.put("user_nation", request.getParameter("user_nation"));
        userInfoMap.put("user_zip", request.getParameter("user_zip"));
        userInfoMap.put("user_address", request.getParameter("user_address"));
        userInfoMap.put("user_address_dtl", request.getParameter("user_address_dtl"));
        userInfoMap.put("user_cp", request.getParameter("user_cp"));
        userInfoMap.put("user_tel", request.getParameter("user_tel"));
        userInfoMap.put("user_profile", request.getParameter("user_profile"));

        formService.insertUserInfo(userInfoMap);

        HashMap<String, String> personalInfoMap = new HashMap<>();

        personalInfoMap.put("user_no", request.getParameter("user_no"));
        personalInfoMap.put("mil_srvc", request.getParameter("mil_srvc"));
        personalInfoMap.put("mil_type", request.getParameter("mil_type"));
        personalInfoMap.put("mil_type_dtl", request.getParameter("mil_type_dtl"));
        personalInfoMap.put("mil_discharge", request.getParameter("mil_discharge"));
        personalInfoMap.put("mil_exem", request.getParameter("mil_exem"));
        personalInfoMap.put("mil_start_date", request.getParameter("mil_start_date"));
        personalInfoMap.put("mil_end_date", request.getParameter("mil_end_date"));
        personalInfoMap.put("vtr_srvc", request.getParameter("vtr_srvc"));
        personalInfoMap.put("vtr_relation", request.getParameter("vtr_relation"));
        personalInfoMap.put("vtr_num", request.getParameter("vtr_num"));
        personalInfoMap.put("dis_srvc", request.getParameter("dis_srvc"));
        personalInfoMap.put("dis_class", request.getParameter("dis_class"));
        personalInfoMap.put("dis_rate", request.getParameter("dis_rate"));

        formService.insertPersonalInfo(personalInfoMap);

        return "userForm/user_info";
    }

    @RequestMapping("/highInfo")
    public String eduHighSave(HttpServletRequest request) {

        HashMap<String, String> eduHighMap = new HashMap<>();

        eduHighMap.put("user_no", request.getParameter("user_no"));
        eduHighMap.put("high_name", request.getParameter("high_name"));
        eduHighMap.put("high_loc", request.getParameter("high_loc"));
        eduHighMap.put("high_ser", request.getParameter("high_ser"));
        eduHighMap.put("high_grd", request.getParameter("high_grd"));
        eduHighMap.put("high_start_date", request.getParameter("high_start_date"));
        eduHighMap.put("high_end_date", request.getParameter("high_end_date"));
        eduHighMap.put("high_fn", request.getParameter("high_fn"));

        formService.insertEduHigh(eduHighMap);


        return "userForm/edu_info";
    }
}
