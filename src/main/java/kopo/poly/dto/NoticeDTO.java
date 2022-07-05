package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {
    private String notice_seq;
    private String title;
    private String contents;
    private String regdate;
    private String reg_id;
}
