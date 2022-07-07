package kopo.poly.service;

import kopo.poly.dto.NoticeDTO;

import java.util.List;

public interface INoticeService {
    int InsertNoticeInfo(NoticeDTO pDTO) throws Exception;

    List<NoticeDTO> getNoticeList() throws Exception;

    NoticeDTO getNoticeDetail(NoticeDTO pDTO) throws Exception;

    int noticeDelete(NoticeDTO nDTO) throws Exception;

    int noticeUpdate(NoticeDTO nDTO) throws Exception;
}
