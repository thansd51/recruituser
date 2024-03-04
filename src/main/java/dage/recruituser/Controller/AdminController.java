package dage.recruituser.Controller;

import dage.recruituser.DTO.AppBoardDTO;
import dage.recruituser.Services.AppBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class AdminController {

    @Autowired
    AppBoardService appBoardService;

    @GetMapping("/admin_home")
    public String admin_home(HttpSession session, Model model) {
        List<AppBoardDTO> anno_list = appBoardService.annoList();

        for (AppBoardDTO dto : anno_list) {
            Date endDate = dto.getAppEndDate();
            Date currentDate = new Date();

            long diffInMillies = Math.abs(endDate.getDate() - currentDate.getDate());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.DAYS);

            dto.setAppDday(diff);
        }

        session.setAttribute("annoList", anno_list);
        model.addAttribute("annoList", anno_list);

        return "adminPage/admin_home";
    }
}
