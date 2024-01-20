package dage.recruituser.Controller;

import dage.recruituser.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppBoardController {

    @Autowired
    BoardService boardService;

//    @GetMapping("/app_form/{user_name}")
//    public String app_form(Model model, @PathVariable("user_name") String user_name, HttpServletRequest request) {
////        String userId = request.getParameter("user_id");
//        model.addAttribute("user_name",user_name);
////        model.addAttribute("id", userId);
//        return "userForm/app_form";
//    }

//    @GetMapping("/app_form")
//    public String app_form(Model model) {
//        String app_title = "한희건";
//        model.addAttribute("app_title", app_title);
//        return "userForm/app_form";
//    }

//    @GetMapping("/app_board/{app_no}")
//    public String appBoard(@PathVariable int app_no, Model model, HttpSession session){
//
//        return "userForm/app_form";
//    }


    @GetMapping("/user_info")
    public String user_info() {
        return "userForm/user_info";
    }

    @GetMapping("/edu_info")
    public String edu_info() {
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
