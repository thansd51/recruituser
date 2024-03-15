package dage.recruituser.Controller;

import dage.recruituser.DTO.*;
import dage.recruituser.Services.AppBoardService;
import dage.recruituser.Services.FormService;
import dage.recruituser.Services.UserManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class AdminController {
    @Autowired
    AppBoardService appBoardService;
    @Autowired
    UserManageService userManageService;
    @Autowired
    FormService formService;

    /* 관리 메인 화면 */
    @RequestMapping("/admin_home")
    public String admin_home(HttpSession session, Model model, HttpServletRequest request) {
        List<AppBoardDTO> anno_list = appBoardService.selectAllAppBoardInfo();

        for (AppBoardDTO dto : anno_list) {
            Date endDate = dto.getAppEndDate();
            Date currentDate = new Date();

            long diffInMillies = Math.abs(endDate.getDate() - currentDate.getDate());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.DAYS);

            dto.setAppDday(diff);
        }

        String app_no = request.getParameter("app_no");

        if (app_no != null) {
            session.setAttribute("app_no", app_no);
            System.out.println(app_no);
        }

        model.addAttribute("annoList", anno_list);
        return "/adminPage/admin_home";
    }

    /* 공고 등록/수정 */
    @GetMapping("/anno_crud")
    public String annoInsert(HttpServletRequest request, Model model, HttpSession session) {

        long app_no = 0; // 기본값 설정
        Object appNoObj = session.getAttribute("app_no");
        if (appNoObj instanceof String) {
            try {
                app_no = Long.parseLong((String) appNoObj);
            } catch (NumberFormatException e) {
            }
        } else if (appNoObj instanceof Long) {
            app_no = (Long) appNoObj; // 이미 long 타입인 경우 캐스팅하여 사용
        }

        if (app_no != 0) { // app_no 값이 유효한 경우에만 서비스 호출
            AppBoardDTO appBoard = appBoardService.selectAppBoardInfo(app_no);
            model.addAttribute("appBoard", appBoard);
            session.setAttribute("appBoard", appBoard);
        }

        session.removeAttribute("app_no");

        return "adminPage/popup/anno_crud";
    }


    /* 지원자 관리 */
    @GetMapping("/user_management")
    public String user_management(@RequestParam("app_no") Long app_no,
                                  @RequestParam(name = "form_no", required = false) Integer form_no,
                                  Model model, HttpSession session) {

        session.setAttribute("getAppNo", app_no);

        // 선택한 공고에 해당하는 정보 가져오기
        List<HashMap<String, Object>> getUserList = userManageService.appInfoList(app_no, 0);
        // 새로운 Step1 리스트
        List<HashMap<String, Object>> step1UserList = userManageService.appInfoList(app_no, 1);
        // 새로운 Step2 리스트
        List<HashMap<String, Object>> step2UserList = userManageService.appInfoList(app_no, 2);
        // 새로운 Step2 리스트
        List<HashMap<String, Object>> step3UserList = userManageService.appInfoList(app_no, 3);
        // 새로운 Step2 리스트
        List<HashMap<String, Object>> step4UserList = userManageService.appInfoList(app_no, 4);

          List<HashMap<String, Object>> targetUsers = new ArrayList<>();

        for (HashMap<String, Object> user : getUserList) {
            Integer userFormNo = (Integer) user.get("formNo");
            if (userFormNo != null && userFormNo.equals(form_no)) {
                targetUsers.add(user);
            }
        }

        for (HashMap<String, Object> user : targetUsers) {
            Integer procSeq = (Integer) user.get("procSeq");
            HashMap<String, Object> step = new HashMap<>();
            step.put("proc_seq", procSeq + 1);
            step.put("form_no", form_no);

            userManageService.procUpdate(step);
        }

        model.addAttribute("appTitle", appBoardService.selectAppBoardInfo(app_no).getAppTitle());
        model.addAttribute("step1UserList", step1UserList);
        model.addAttribute("step2UserList", step2UserList);
        model.addAttribute("step3UserList", step3UserList);
        model.addAttribute("step4UserList", step4UserList);

        return "adminPage/user_management";
    }


    /* 지원자 원서 조회 */
    @RequestMapping("/user_preview")
    public String user_preview(@RequestParam("form_no") long form_no, Model model, HttpSession session) {
        String orderBy = "byUnivFnFirst";
        long app_no = (long) session.getAttribute("getAppNo");

        AppBoardDTO appBoard = appBoardService.selectAppBoardInfo(app_no);
        UserDTO appUser = formService.appUser(form_no);
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
        model.addAttribute("user_email", appUser.getUserEmail());
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

        return "adminPage/popup/user_preview";
    }
}
