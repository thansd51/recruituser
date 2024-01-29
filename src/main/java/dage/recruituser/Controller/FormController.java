package dage.recruituser.Controller;

import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.DTO.EduHighDTO;
import dage.recruituser.DTO.EduUnivDTO;
import dage.recruituser.DTO.UserInfoDTO;
import dage.recruituser.Services.AppBoardService;
import dage.recruituser.Services.FormService;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    public String app_form(HttpSession session, Model model, @RequestParam("APP_NO") long app_no) {
        AppBoardDTO appBoard = appBoardService.appBoardInfo(app_no);
        session.setAttribute("appBoard", appBoard);
        model.addAttribute("appBoard", appBoard);

        return "userForm/app_form";
    }



    @GetMapping("/user_info")
    public String user_info(HttpSession session, Model model, @RequestParam("USER_NO") long user_no) {
        UserInfoDTO userInfo = formService.userInfo(user_no);
        session.setAttribute("userInfo", userInfo);
        model.addAttribute("userInfo", userInfo);

        return "userForm/user_info";
    }

    @GetMapping("/edu_info")
    public String edu_info(HttpSession session, Model model, @RequestParam("USER_NO") long user_no) {
        EduHighDTO eduHighInfo = formService.eduHigh(user_no);
        EduUnivDTO eduUniv = formService.eduUniv(user_no);

        session.setAttribute("eduHighInfo", eduHighInfo);
        session.setAttribute("eduUniv", eduUniv);

        model.addAttribute("eduHighInfo", eduHighInfo);
        model.addAttribute("eduUniv", eduUniv);

        System.out.println(model.addAttribute("eduHighInfo", eduHighInfo));
        System.out.println(model.addAttribute("eduUniv", eduUniv));

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
