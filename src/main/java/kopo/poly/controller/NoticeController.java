package kopo.poly.controller;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class NoticeController {
    @GetMapping(value = "index")
    public String indexPage() throws Exception {
        log.info(this.getClass().getName() + " .indexPage Start !!");
        log.info(this.getClass().getName() + " .indexPage End !!");

        return "index";
    }

    @GetMapping(value = "noticeInfo")
    public String noticeInfo() throws Exception {
        log.info(this.getClass().getName() + " .indexPage Start !!");
        log.info(this.getClass().getName() + " .indexPage End !!");

        return "form";
    }

    @GetMapping(value = "getNoticeData")
    public String getNoticeData(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .getNoticeData Start !!");
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));
        String author = CmmUtil.nvl(request.getParameter("author"));

        log.info("title : " + title);
        log.info("content : " + contents);
        log.info("author : " + author);

        model.addAttribute("title", title);
        model.addAttribute("contents", contents);
        model.addAttribute("author", author);

        log.info(this.getClass().getName() + " .getNoticeData End !!");
        return "getNoticeData";
    }

    @PostMapping(value = "postNoticeData")
    public String PostNoticeData(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .postNoticeData Start !!");
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));
        String author = CmmUtil.nvl(request.getParameter("author"));

        log.info("title : " + title);
        log.info("content : " + contents);
        log.info("author : " + author);


        model.addAttribute("title", title);
        model.addAttribute("contents", contents);
        model.addAttribute("author", author);


        log.info(this.getClass().getName() + " .postNoticeData End !!");
        return "postNoticeData";
    }

    @Resource(name = "NoticeService")
    private INoticeService noticeService;

    @RequestMapping(value = "getInsertNotice")
    public String getInsertNotice(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .getNoticeData Start!!");
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("reg_id : " + reg_id);
        log.info("title : " + title);
        log.info("contents : " + contents);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setTitle(title);
        pDTO.setContents(contents);
        pDTO.setReg_id(reg_id);

        //저장되면 1의값을 안되면 0을 가져옴.
        int res = noticeService.InsertNoticeInfo(pDTO);
        String msg;
        String url = "/getNoticeList";

        if (res > 0) {
            msg = "등록에 성공하셨습니다.";
        } else {
            msg = "등록에 실패하셨습니다";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + " .getNoticeData End!!");
        return "redirect";
    }
}
