package kopo.poly.persistance.mapper;

import kopo.poly.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface INoticeMapper {
    int InsertNoticeInfo(NoticeDTO pDTO) throws Exception;

    List<NoticeDTO> getNoticeList() throws Exception;
}
