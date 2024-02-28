package dage.recruit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/recruit_write")
    public String recruit_write(){
        return "index";
    }
    @GetMapping("/info_modify")
    public String board_modify(){
        return "board/info_modify";
    }

    @GetMapping("/content")
    public String content(){
        return "content/content";
    }

}
