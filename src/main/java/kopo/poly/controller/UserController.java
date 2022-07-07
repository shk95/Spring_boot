package kopo.poly.controller;

import kopo.poly.dto.UserinfoDTO;
import kopo.poly.service.IUserService;
import kopo.poly.service.impl.UserService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTML;

@Slf4j
@Controller
public class UserController {

    @Resource(name = "UserService")
    private IUserService userService;

    //로그인시도
    @PostMapping(value = "logIn")
    public String logIn() throws Exception {
        return "redirect";
    }

    //가입버튼 동작
    @GetMapping(value = "goSignUpPage")
    public String goSignUpPage() throws Exception {
        log.info(this.getClass().getName() + " .goSignUpPage Starts !");
        log.info(this.getClass().getName() + " .goSignUpPage Ends!");

        return "signUpPage";
    }

    //회원가입하기
    @PostMapping(value = "doSignUp")
    public String doSignUp(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .doSignUp Starts!");
        String user_id = CmmUtil.nvl(request.getParameter("user_id"));
        String user_pwd = CmmUtil.nvl(request.getParameter("user_pwd"));
        String user_email = CmmUtil.nvl(request.getParameter("user_email"));
        String user_name = CmmUtil.nvl(request.getParameter("user_name"));

        log.info("user_id : " + user_id);
        log.info("user_pwd : " + user_pwd);
        log.info("user_email : " + user_email);
        log.info("user_name : " + user_name);

        model.addAttribute("user_id", user_id);
        model.addAttribute("user_pwd", user_pwd);
        model.addAttribute("user_email", user_email);
        model.addAttribute("user_name", user_name);

        UserinfoDTO pDTO = new UserinfoDTO();
        pDTO.setUser_id(user_id);
        pDTO.setUser_pwd(user_pwd);
        pDTO.setUser_email(user_email);
        pDTO.setUser_name(user_name);

        int res = userService.InsertUserInfo(pDTO);

        String msg;
        String url = "/signUpPage";

        if (res > 0) {
            msg = "등록에 성공하셨습니다.";
        } else {
            msg = "등록에 실패하셨습니다";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);


        log.info(this.getClass().getName() + " .doSignUp Ends!");

        return "redirect";
    }
}
