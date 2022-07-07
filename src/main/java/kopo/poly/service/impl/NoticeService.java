package kopo.poly.service.impl;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.persistance.mapper.INoticeMapper;
import kopo.poly.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.NotOwnerException;
import java.util.List;

@Slf4j
@Service("NoticeService")
public class NoticeService implements INoticeService {

    private final INoticeMapper noticeMapper;

    @Autowired
    public NoticeService(INoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public int InsertNoticeInfo(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + "InsertNoticeInfo start !");
        int res = noticeMapper.InsertNoticeInfo(pDTO);
        log.info(this.getClass().getName() + "InsertNoticeInfo end !");
        return res;
    }

    @Override
    public List<NoticeDTO> getNoticeList() throws Exception {
        log.info(this.getClass().getName() + "InsertNoticeInfo start !");
        List<NoticeDTO> rList = noticeMapper.getNoticeList();
        log.info(this.getClass().getName() + "InsertNoticeInfo end !");

        return rList;
    }

    @Override
    public NoticeDTO getNoticeDetail(NoticeDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + "getNoticeDetail start !");
        NoticeDTO rDTO = noticeMapper.getNoticeDetail(pDTO);
        log.info(this.getClass().getName() + "getNoticeDetail start !");
        return rDTO;
    }

    @Override
    public int noticeDelete(NoticeDTO nDTO) throws Exception {
        log.info(this.getClass().getName() + "noticeDelete start !");
        int res = noticeMapper.noticeDelete(nDTO);

        log.info("res : " + res);
        log.info(this.getClass().getName() + "noticeDelete end !");

        return res;
    }

    @Override
    public int noticeUpdate(NoticeDTO nDTO) throws Exception {
        log.info(this.getClass().getName() + "noticeUpdate Starts !");

        int res = noticeMapper.noticeUpdate(nDTO);
        log.info("res : " + res);

        log.info(this.getClass().getName() + "noticeUpdate Ends !");

        return res;
    }
}
