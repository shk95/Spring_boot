package kopo.poly.service;


import kopo.poly.dto.UserinfoDTO;

public interface IUserService {
    int InsertUserInfo(UserinfoDTO pDTO) throws Exception;
}
