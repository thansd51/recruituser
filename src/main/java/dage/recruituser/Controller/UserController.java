package dage.recruituser.Controller;

import dage.recruituser.DTO.UserDTO;
import dage.recruituser.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/app_form")
    public String openAppBoard(String user_name, Model model) {
        UserDTO userDTO = userService.selectService(user_name);
        String userName = userDTO.getUserName();
        model.addAttribute("user_name", userName);
        return "userForm/app_form";
    }

}
