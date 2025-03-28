package com.microservices.services;

import com.microservices.entity.HotelUser;
import com.microservices.projection.ProjectNumberRoleDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserServcie {
    public void saveUser(HotelUser user);
    public List<HotelUser>getAll();

    public HotelUser getByUserId(String id);
    public  void deleteById(String id);
    public void updateUser(String id,HotelUser user);
    public List<HotelUser>getByEmailOrderByUserId(String email);
    public List<HotelUser>getByAboutMe(String aboutMe);

    public  List<ProjectNumberRoleDto> getNumbers();

    public void saveBulk(MultipartFile file) throws Exception;
}
