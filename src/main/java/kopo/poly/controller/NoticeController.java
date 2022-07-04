package kopo.poly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
