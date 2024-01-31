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

//    @GetMapping("/app_form/{user_name}")
//    public String app_form(Model model, @PathVariable("user_name") String user_name, HttpServletRequest request) {
////        String userId = request.getParameter("user_id");
//        model.addAttribute("user_name",user_name);
////        model.addAttribute("id", userId);
//        return "userForm/app_form";
//    }

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

        session.setAttribute("infoUser", infoUser);
        session.setAttribute("infoPerson", infoPerson);

        model.addAttribute("infoUser", infoUser);
        model.addAttribute("infoPerson", infoPerson);

        System.out.println(model.addAttribute("infoUser", infoUser));
        System.out.println(model.addAttribute("infoPerson", infoPerson));

        return "userForm/user_info";
    }

    @GetMapping("/edu_info")
    public String eduInfo(HttpSession session, Model model, @RequestParam("form_no") long form_no) {
        InfoEduHighDTO eduHighInfo = formService.eduHighInfo(form_no);
        List<InfoEduUnivDTO> eduUnivInfo = formService.eduUnivInfo(form_no);

        session.setAttribute("eduHighInfo", eduHighInfo);
        session.setAttribute("eduUnivInfo", eduUnivInfo);

        model.addAttribute("eduHighInfo", eduHighInfo);
        model.addAttribute("eduUnivInfo", eduUnivInfo);

//        System.out.println(model.addAttribute("eduHighInfo", eduHighInfo));
        System.out.println(model.addAttribute("eduUnivInfo", eduUnivInfo));

//        for (InfoEduUnivDTO eduUnivDTO : eduUnivInfo) {
//            // Your logic here using eduUnivDTO
//            // For example, you can access properties of eduUnivDTO like eduUnivDTO.getPropertyName()
//            // and perform operations as needed.
//            model.addAttribute("eduUnivInfo", eduUnivDTO);
//            System.out.println(model.addAttribute("eduUnivInfo", eduUnivDTO));
//        }


        return "userForm/edu_info";
    }

    @GetMapping("/career_info")
    public String career_info() {
        return "userForm/career_info";
    }

    @GetMapping("/cert_info")
    public String cert_info() {
        return "userForm/cert_info";
    }

    @GetMapping("/act_info")
    public String act_info() {
        return "userForm/act_info";
    }

    @GetMapping("/survey_info")
    public String survey_info() {
        return "userForm/survey_info";
    }

    @GetMapping("/app_post")
    public String app_post() {
        return "userForm/app_post";
    }
}
