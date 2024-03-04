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

    @GetMapping("/user_info")
    public String userInfo(HttpSession session, Model model, @RequestParam("form_no") long form_no_pr) {

        /* 유저 정보 */
        UserDTO appUser = formService.appUser(form_no_pr);
        long form_no = appUser.getFormNo();

        session.setAttribute("form_no", form_no);
        session.setAttribute("user_email", appUser.getUserEmail());

        /* 지원 정보 */
        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");

        InfoUserDTO infoUser = formService.userInfo(form_no);
        InfoPersonDTO infoPerson = formService.personInfo(form_no);

        session.setAttribute("infoUser", infoUser);
        session.setAttribute("infoPerson", infoPerson);

        model.addAttribute("form_no", form_no);
        model.addAttribute("appBoard", appBoard);
        model.addAttribute("infoUser", infoUser);
        model.addAttribute("infoPerson", infoPerson);

        return "userForm/user_info";
    }

    @GetMapping("/edu_info")
    public String eduInfo(HttpSession session, Model model) {

        long form_no = (long) session.getAttribute("form_no");
        String orderBy = "byUnivSeq";
        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");

        InfoEduHighDTO eduHighInfo = formService.eduHighInfo(form_no);
        List<InfoEduUnivDTO> eduUnivInfo = formService.eduUnivInfo(form_no, orderBy);

        model.addAttribute("form_no", form_no);
        model.addAttribute("appBoard", appBoard);
        model.addAttribute("eduHighInfo", eduHighInfo);
        model.addAttribute("eduUnivInfo", eduUnivInfo);

        return "userForm/edu_info";
    }

    @GetMapping("/career_info")
    public String career_info(HttpSession session, Model model) {

        long form_no = (long) session.getAttribute("form_no");
        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");

        List<InfoCareerDTO> careerInfo = formService.careerInfo(form_no);
        List<InfoProjectDTO> projectInfo = formService.projectInfo(form_no);

        model.addAttribute("form_no", form_no);
        model.addAttribute("appBoard", appBoard);
        model.addAttribute("careerInfo", careerInfo);
        model.addAttribute("projectInfo", projectInfo);

        return "userForm/career_info";
    }

    @GetMapping("/cert_info")
    public String cert_info(HttpSession session, Model model) {

        long form_no = (long) session.getAttribute("form_no");
        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");

        List<InfoCertDTO> certInfo = formService.certInfo(form_no);
        List<InfoLangDTO> langInfo = formService.langInfo(form_no);
        List<InfoOaDTO> oaInfo = formService.oaInfo(form_no);

        model.addAttribute("form_no", form_no);
        model.addAttribute("appBoard", appBoard);
        model.addAttribute("certInfo", certInfo);
        model.addAttribute("langInfo", langInfo);
        model.addAttribute("oaInfo", oaInfo);

        return "userForm/cert_info";
    }

    @GetMapping("/act_info")
    public String act_info(HttpSession session, Model model) {

        long form_no = (long) session.getAttribute("form_no");
        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");

        List<InfoActDTO> actInfo = formService.actInfo(form_no);
        List<InfoAwdDTO> awdInfo = formService.awdInfo(form_no);

        model.addAttribute("form_no", form_no);
        model.addAttribute("appBoard", appBoard);
        model.addAttribute("actInfo", actInfo);
        model.addAttribute("awdInfo", awdInfo);

        return "userForm/act_info";
    }


    @GetMapping("/surv_info")
    public String survey_info(HttpSession session, Model model) {

        long form_no = (long) session.getAttribute("form_no");
        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");

        List<InfoSurvDTO> survInfo = formService.survInfo(appBoard.getAppNo(), form_no);

        session.setAttribute("survInfo", survInfo);

        model.addAttribute("appBoard", appBoard);
        model.addAttribute("form_no", form_no);
        model.addAttribute("survInfo", survInfo);

        return "userForm/surv_info";
    }

    @GetMapping("/app_post")
    public String app_post(HttpSession session, Model model) {

        long form_no = (long) session.getAttribute("form_no");
        String orderBy = "byUnivFnFirst";
        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");
        String user_email = (String) session.getAttribute("user_email");

        InfoUserDTO infoUser = formService.userInfo(form_no);
        InfoPersonDTO infoPerson = formService.personInfo(form_no);
        InfoEduHighDTO eduHighInfo = formService.eduHighInfo(form_no);
        List<InfoEduUnivDTO> eduUnivInfo = formService.eduUnivInfo(form_no, orderBy);
        List<InfoCareerDTO> careerInfo = formService.careerInfo(form_no);
        List<InfoProjectDTO> projectInfo = formService.projectInfo(form_no);
        List<InfoCertDTO> certInfo = formService.certInfo(form_no);
        List<InfoLangDTO> langInfo = formService.langInfo(form_no);
        List<InfoOaDTO> oaInfo = formService.oaInfo(form_no);
        List<InfoActDTO> actInfo = formService.actInfo(form_no);
        List<InfoAwdDTO> awdInfo = formService.awdInfo(form_no);
        List<InfoSurvDTO> survInfo = formService.survInfo(appBoard.getAppNo(), form_no);

        model.addAttribute("form_no", form_no);
        model.addAttribute("appBoard", appBoard);
        model.addAttribute("user_email", user_email);
        model.addAttribute("infoUser", infoUser);
        model.addAttribute("infoPerson", infoPerson);
        model.addAttribute("eduHighInfo", eduHighInfo);
        model.addAttribute("eduUnivInfo", eduUnivInfo);
        model.addAttribute("careerInfo", careerInfo);
        model.addAttribute("projectInfo", projectInfo);
        model.addAttribute("certInfo", certInfo);
        model.addAttribute("langInfo", langInfo);
        model.addAttribute("oaInfo", oaInfo);
        model.addAttribute("actInfo", actInfo);
        model.addAttribute("awdInfo", awdInfo);
        model.addAttribute("survInfo", survInfo);

        model.addAttribute("getUniv", eduUnivInfo.get(0));
        model.addAttribute("getCareer", careerInfo.get(0));
        model.addAttribute("getProject", projectInfo.get(0));
        model.addAttribute("getCert", certInfo.get(0));
        model.addAttribute("getLang", langInfo.get(0));
        model.addAttribute("getOa", oaInfo.get(0));
        model.addAttribute("getAct", actInfo.get(0));
        model.addAttribute("getAwd", awdInfo.get(0));

        return "userForm/app_post";
    }

}
