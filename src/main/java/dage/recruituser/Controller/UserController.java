package dage.recruituser.Controller;

import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.DTO.InfoPersonDTO;
import dage.recruituser.DTO.InfoUserDTO;
import dage.recruituser.DTO.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @GetMapping("/applicant_login")
    public String applicant_login() {

        return "userForm/user_login";
    }
}
