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
import java.util.ArrayList;
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

        String form_no = String.valueOf(AppUser.get("form_no"));

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

        String form_no = String.valueOf(infoUser.get("form_no"));

        return form_no;
    }

    @RequestMapping("/infoEdu")
    public String eduHighSave(HttpServletRequest request) {

        HashMap<String, String> eduHighInfo = new HashMap<>();

        eduHighInfo.put("form_no", request.getParameter("form_no"));
        eduHighInfo.put("high_name", request.getParameter("high_name"));
        eduHighInfo.put("high_loc", request.getParameter("high_loc"));
        eduHighInfo.put("high_ser", request.getParameter("high_ser"));
        eduHighInfo.put("high_grd", request.getParameter("high_grd"));
        eduHighInfo.put("high_start_date", request.getParameter("high_start_date"));
        eduHighInfo.put("high_end_date", request.getParameter("high_end_date"));
        eduHighInfo.put("high_fn", request.getParameter("high_fn"));

        formService.insertEduHigh(eduHighInfo);

        HashMap<String, String> eduUnivInfo = new HashMap<>();

        eduUnivInfo.put("form_no", request.getParameter("form_no"));
        eduUnivInfo.put("univ_seq", request.getParameter("univ_seq"));
        eduUnivInfo.put("univ_edu", request.getParameter("univ_edu"));
        eduUnivInfo.put("univ_name", request.getParameter("univ_name"));
        eduUnivInfo.put("univ_loc", request.getParameter("univ_loc"));
        eduUnivInfo.put("univ_ser", request.getParameter("univ_ser"));
        eduUnivInfo.put("univ_grd", request.getParameter("univ_grd"));
        eduUnivInfo.put("univ_start_date", request.getParameter("univ_start_date"));
        eduUnivInfo.put("univ_dn", request.getParameter("univ_dn"));
        eduUnivInfo.put("univ_ser", request.getParameter("univ_ser"));
        eduUnivInfo.put("univ_cls", request.getParameter("univ_cls"));
        eduUnivInfo.put("univ_cls_mul", request.getParameter("univ_cls_mul"));
        eduUnivInfo.put("univ_cls_sub", request.getParameter("univ_cls_sub"));
        eduUnivInfo.put("univ_crd", request.getParameter("univ_crd"));
        eduUnivInfo.put("univ_crd_max", request.getParameter("univ_crd_max"));
        eduUnivInfo.put("univ_fn", request.getParameter("univ_fn"));

        formService.insertEduUniv(eduUnivInfo);

        String form_no = String.valueOf(eduHighInfo.get("form_no"));

        return form_no;
    }

    @RequestMapping("/infoCareer")
    public String careerSave(HttpServletRequest request) {

        HashMap<String, String> careerInfo = new HashMap<>();

        careerInfo.put("form_no", request.getParameter("form_no"));
        careerInfo.put("co_name", request.getParameter("co_name"));
        careerInfo.put("co_start_date", request.getParameter("co_start_date"));
        careerInfo.put("co_end_date", request.getParameter("co_end_date"));
        careerInfo.put("co_loc", request.getParameter("co_loc"));
        careerInfo.put("co_cls", request.getParameter("co_cls"));
        careerInfo.put("co_form_emp", request.getParameter("co_form_emp"));
        careerInfo.put("co_salary", request.getParameter("co_salary"));
        careerInfo.put("co_dept", request.getParameter("co_dept"));
        careerInfo.put("co_rank", request.getParameter("co_rank"));
        careerInfo.put("co_work", request.getParameter("co_work"));
        careerInfo.put("co_retire", request.getParameter("co_retire"));

        formService.insertCareer(careerInfo);

        HashMap<String, String> projInfo = new HashMap<>();

        projInfo.put("form_no", request.getParameter("form_no"));
        projInfo.put("proj_name", request.getParameter("proj_name"));
        projInfo.put("proj_start_date", request.getParameter("proj_start_date"));
        projInfo.put("proj_end_date", request.getParameter("proj_end_date"));
        projInfo.put("proj_order", request.getParameter("proj_order"));
        projInfo.put("proj_loc", request.getParameter("proj_loc"));
        projInfo.put("proj_work", request.getParameter("proj_work"));

        formService.insertProject(projInfo);

        String form_no = String.valueOf(careerInfo.get("form_no"));

        return form_no;
    }

    @RequestMapping("/infoCert")
    public String certSave(HttpServletRequest request) {

        HashMap<String, String> certInfo = new HashMap<>();

        certInfo.put("form_no", request.getParameter("form_no"));
        certInfo.put("cert_cls", request.getParameter("cert_cls"));
        certInfo.put("cert_num", request.getParameter("cert_num"));
        certInfo.put("cert_isu", request.getParameter("cert_isu"));
        certInfo.put("cert_date", request.getParameter("cert_date"));

        formService.insertCert(certInfo);

        HashMap<String, String> langInfo = new HashMap<>();

        langInfo.put("form_no", request.getParameter("form_no"));
        langInfo.put("lang_name", request.getParameter("lang_name"));
        langInfo.put("lang_lv", request.getParameter("lang_lv"));

        formService.insertLang(langInfo);

        HashMap<String, String> OAInfo = new HashMap<>();

        OAInfo.put("form_no", request.getParameter("form_no"));
        OAInfo.put("oa_name", request.getParameter("oa_name"));
        OAInfo.put("oa_lv", request.getParameter("oa_lv"));

        formService.insertOA(OAInfo);

        String form_no = String.valueOf(certInfo.get("form_no"));

        return form_no;
    }

    @RequestMapping("/infoAct")
    public String actSave(HttpServletRequest request) {

        HashMap<String, String> actInfo = new HashMap<>();

        actInfo.put("form_no", request.getParameter("form_no"));
        actInfo.put("act_name", request.getParameter("act_name"));
        actInfo.put("act_start_date", request.getParameter("act_start_date"));
        actInfo.put("act_end_date", request.getParameter("act_end_date"));
        actInfo.put("act_fd", request.getParameter("act_fd"));
        actInfo.put("act_conduct", request.getParameter("act_conduct"));
        actInfo.put("act_content", request.getParameter("act_content"));

        formService.insertAct(actInfo);

        HashMap<String, String> awdInfo = new HashMap<>();

        awdInfo.put("form_no", request.getParameter("form_no"));
        awdInfo.put("awd_name", request.getParameter("awd_name"));
        awdInfo.put("awd_date", request.getParameter("awd_date"));
        awdInfo.put("awd_conduct", request.getParameter("awd_conduct"));
        awdInfo.put("awd_content", request.getParameter("awd_content"));

        formService.insertAwd(awdInfo);

        String form_no = String.valueOf(actInfo.get("form_no"));

        return form_no;
    }

    @RequestMapping("/infoSurv")
    public String survSave(HttpServletRequest request) {


        HashMap<String, String> survInfo = new HashMap<>();

        survInfo.put("quest_no", request.getParameter("quest_no"));
        survInfo.put("form_no", request.getParameter("form_no"));
        survInfo.put("surv_answer", request.getParameter("surv_answer"));

        formService.insertSurv(survInfo);

        String form_no = String.valueOf(survInfo.get("form_no"));

        return form_no;
    }

    @RequestMapping("/appPost")
    public String userFormPost(HttpServletRequest request) {

        long form_no = Integer.valueOf(request.getParameter("form_no"));
        System.out.println(form_no);
        formService.deleteUserForm(form_no);

        return "userForm/edu_info";
    }

}
