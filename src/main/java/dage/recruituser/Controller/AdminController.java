package dage.recruituser.Controller;

import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.Services.AppBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    AppBoardService appBoardService;

    @GetMapping("/anno_list")
    public String anno_list(HttpSession session, Model model) {
        List<AppBoardDTO> anno_list = appBoardService.annoList();

        session.setAttribute("annoList", anno_list);
        model.addAttribute("annoList", anno_list);

        return "annoBoard/anno_list";
    }

    @GetMapping("/anno_detail")
    public String board_modify(HttpSession session, Model model, @RequestParam("app_no") long app_no) {

        AppBoardDTO appBoard = appBoardService.appBoardInfo(app_no);

        session.setAttribute("appBoard", appBoard);
        model.addAttribute("appBoard", appBoard);

        return "annoBoard/anno_detail";
    }

    @GetMapping("/app_form")
    public String app_form(HttpSession session, Model model) {

        AppBoardDTO appBoard = (AppBoardDTO) session.getAttribute("appBoard");
        model.addAttribute("appBoard", appBoard);

        return "userForm/app_form";
    }

}