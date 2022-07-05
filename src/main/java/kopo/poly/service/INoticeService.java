package kopo.poly.service;

import kopo.poly.dto.NoticeDTO;

public interface INoticeService {
    int InsertNoticeInfo(NoticeDTO pDTO) throws Exception;
}
