package kopo.poly.service.impl;



import kopo.poly.dto.UserinfoDTO;
import kopo.poly.persistance.mapper.IUserMapper;
import kopo.poly.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service("UserService")
public class UserService implements IUserService {

    private final IUserMapper userMapper;

    @Autowired
    public UserService(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public int InsertUserInfo(UserinfoDTO pDTO) throws Exception {
        int res = userMapper.InsertUserInfo(pDTO);
        return res;
    }
}
