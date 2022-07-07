package kopo.poly.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
import java.util.ArrayList;
import java.util.List;

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
    public String getInsertNotice(HttpServletRequest request, Model model) throws Exception {
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

    @RequestMapping(value = "getNoticeList")
    public String getNoticeList(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .getNoticeList Start !!");
        /*String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("reg_id : " + reg_id);
        log.info("title : " + reg_id);
        log.info("content : " + reg_id);

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setTitle(title);
        pDTO.setTitle(contents);
        pDTO.setTitle(reg_id);

        int res = noticeService.InsertNoticeInfo(pDTO)

        String msg;
        String url = "/getNoticeList";*/

        List<NoticeDTO> rList = noticeService.getNoticeList();

        log.info(String.valueOf(rList.size()));
        if (rList == null) {
            rList = new ArrayList<>();
        }
        model.addAttribute("rList", rList);

        log.info(this.getClass().getName() + " .getNoticeList End !!");

        return "noticeList";
    }

    @RequestMapping(value = "noticeDetail")
    public String noticeDetail(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .noticeDetail start !!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setNotice_seq(notice_seq);

        NoticeDTO rDTO = noticeService.getNoticeDetail(pDTO);
        if (rDTO == null) {
            model.addAttribute("msg", "존재하지 않는 게시물입니다.");
            model.addAttribute("url", "getNoticeList");
            return "redirect";
        }

        model.addAttribute("rDTO", rDTO);
        log.info(this.getClass().getName() + " .NoticeDetail End !!");

        return "noticeDetail";
    }

    @GetMapping(value = "noticeDelete")
    public String noticeDelete(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .noticeDelete Start !!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("notice_seq " + notice_seq);

        NoticeDTO nDTO = new NoticeDTO();
        nDTO.setNotice_seq(notice_seq);

        int res = noticeService.noticeDelete(nDTO);
        String msg;
        String url;

        if (res == 1) {
            msg = "삭재 성공";
            url = "getNoticeList";
        } else {
            msg = "삭제 실패";
            url = "noticeDetail?no=" + notice_seq;
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        return "redirect";
    }

    @GetMapping(value = "noticeUpdate")
    public String noticeUpdate(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .noticeUpdate Starts !!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("notice_seq : " + notice_seq);
        log.info("notice_seq model: " + model);

        model.addAttribute("notice_seq", notice_seq);


        log.info(this.getClass().getName() + " .noticeUpdate Ends !!");
        return "editForm";
    }

    @GetMapping(value = "doNoticeUpdate")
    public String doNoticeUpdate(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .doNoticeUpdate Starts !!");
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        String notice_seq = request.getParameter("notice_seq");

        log.info("title : " + title);
        log.info("contents : " + contents);
        log.info("notice_seq : " + notice_seq);

        NoticeDTO nDTO = new NoticeDTO();
        nDTO.setNotice_seq(notice_seq);
        nDTO.setTitle(title);
        nDTO.setContents(contents);

        int res = noticeService.noticeUpdate(nDTO);

        String msg;
        String url;
        if (res > 0) {
            msg = "수정성공";
            url = "getNoticeList";
        } else {
            msg = "수정실패";
            url = "getNoticeList";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + " .doNoticeUpdate Ends !!");

        return "redirect";
    }
}
