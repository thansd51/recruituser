package dage.recruituser.Controller;

import dage.recruituser.DTO.*;
import dage.recruituser.Services.AppBoardService;
import dage.recruituser.Services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    FormService formService;

    @Autowired
    AppBoardService appBoardService;

    @GetMapping("/app_form")
    public String app_form(HttpSession session, Model model, @RequestParam("app_no") long app_no) {

        AppBoardDTO appBoard = appBoardService.appBoardInfo(app_no);

        session.setAttribute("appBoard", appBoard);

        model.addAttribute("appBoard", appBoard);

        return "userForm/app_form";
    }


    @GetMapping("/user_info")
    public String userInfo(HttpSession session, Model model, @RequestParam("form_no") long form_no) {

        InfoUserDTO infoUser = formService.userInfo(form_no);
        InfoPersonDTO infoPerson = formService.personInfo(form_no);

        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");

        session.setAttribute("infoUser", infoUser);
        session.setAttribute("infoPerson", infoPerson);

        model.addAttribute("app_job", appBoard.getAppJob());
        model.addAttribute("infoUser", infoUser);
        model.addAttribute("infoPerson", infoPerson);

        return "userForm/user_info";
    }

    @GetMapping("/edu_info")
    public String eduInfo(HttpSession session, Model model, @RequestParam("form_no") long form_no) {

        InfoEduHighDTO eduHighInfo = formService.eduHighInfo(form_no);
        InfoEduUnivDTO eduUnivInfo = formService.eduUnivInfo(form_no);

        session.setAttribute("eduHighInfo", eduHighInfo);
        session.setAttribute("eduUnivInfo", eduUnivInfo);

        model.addAttribute("eduHighInfo", eduHighInfo);
        model.addAttribute("eduUnivInfo", eduUnivInfo);

        return "userForm/edu_info";
    }

    @GetMapping("/career_info")
    public String career_info(HttpSession session, Model model, @RequestParam("form_no") long form_no) {

        InfoCareerDTO careerInfo = formService.careerInfo(form_no);
        InfoProjectDTO projectInfo = formService.projectInfo(form_no);

        session.setAttribute("careerInfo", careerInfo);
        session.setAttribute("projectInfo", projectInfo);

        model.addAttribute("careerInfo", careerInfo);
        model.addAttribute("projectInfo", projectInfo);

        return "userForm/career_info";
    }

    @GetMapping("/cert_info")
    public String cert_info(HttpSession session, Model model, @RequestParam("form_no") long form_no) {

        InfoCertDTO certInfo = formService.certInfo(form_no);
        InfoLangDTO langInfo = formService.langInfo(form_no);
        InfoOaDTO oaInfo = formService.oaInfo(form_no);


        session.setAttribute("certInfo", certInfo);
        session.setAttribute("langInfo", langInfo);
        session.setAttribute("oaInfo", oaInfo);

        model.addAttribute("certInfo", certInfo);
        model.addAttribute("langInfo", langInfo);
        model.addAttribute("oaInfo", oaInfo);

        return "userForm/cert_info";
    }

    @GetMapping("/act_info")
    public String act_info(HttpSession session, Model model, @RequestParam("form_no") long form_no) {

        InfoActDTO actInfo = formService.actInfo(form_no);
        InfoAwdDTO awdInfo = formService.awdInfo(form_no);

        session.setAttribute("actInfo", actInfo);
        session.setAttribute("awdInfo", awdInfo);

        model.addAttribute("actInfo", actInfo);
        model.addAttribute("awdInfo", awdInfo);

        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");
        model.addAttribute("app_no", appBoard.getAppNo());

        return "userForm/act_info";
    }



    @GetMapping("/survey_info")
    public String survey_info(HttpSession session, Model model,
                              @RequestParam("app_no") long app_no,
                              @RequestParam("form_no") long form_no) {

        List<InfoSurvDTO> survInfo = formService.survInfo(app_no, form_no);
        model.addAttribute("survInfo", survInfo);

        long formNO = survInfo.get(0).getFormNo();
        model.addAttribute("formNO", formNO);

        session.setAttribute("survInfo", survInfo);
        session.setAttribute("formNO", formNO);

        return "userForm/survey_info";
    }

    @GetMapping("/app_post")
    public String app_post(HttpSession session, Model model) {

        InfoUserDTO infoUser = (InfoUserDTO) session.getAttribute("infoUser");

        model.addAttribute("form_no", infoUser.getFormNo());

        return "userForm/app_post";
    }



}
