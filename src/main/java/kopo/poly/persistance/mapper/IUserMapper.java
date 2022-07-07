package kopo.poly.persistance.mapper;

import kopo.poly.dto.UserinfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {

    int InsertUserInfo(UserinfoDTO pDTO);
}
