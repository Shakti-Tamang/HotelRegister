package com.microservices.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.microservices.entity.Hotel;
import com.microservices.entity.HotelRatingModel;
import com.microservices.entity.HotelUser;
import com.microservices.feignclient.RatingFiegnService;
import com.microservices.projection.ProjectNumberRole;
import com.microservices.projection.ProjectNumberRoleDto;
import com.microservices.repo.UserRepo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.InputStreamReader;
import java.lang.module.ResolutionException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private RatingFiegnService ratingFiegnService;

    @Autowired
    Cloudinary cloudinary;

    private final Logger logger;

    public UserServiceImpl() {
        this.logger = LoggerFactory.getLogger(UserServiceImpl.class);
    }

    @Override
    public void saveUser(HotelUser user) {
        user.setUserId(UUID.randomUUID().toString());
        userRepo.save(user);

    }


    @Transactional
    //services intercommunication using rest template
    @Override
    public List<HotelUser> getAll() {
        List<HotelUser> users = userRepo.findAll();
        List<HotelRatingModel> list = null;
        boolean found = false;
        for (HotelUser li : users) {


            try {
                list = ratingFiegnService.getAllByUserId(li.getUserId());
                if (!list.isEmpty()) {
                    li.setList(list);
                    found = true;
                } else {

                    li.setList(new ArrayList<>());
                }
            } catch (FeignException.NotFound e) {
                // Handle 404 error gracefully
                logger.error("Hotel ratings not found for userId: " + li.getUserId());
            }


        }

        return users;
    }

    @Override
    public HotelUser getByUserId(String id) {
        Optional<HotelUser> hotelUser = userRepo.findById(id);

        List<HotelRatingModel> list = null;
        try {
            list = ratingFiegnService.getAllByUserId(id);
        } catch (FeignException.NotFound e) {
            // Handle 404 error gracefully
            logger.error("Hotel ratings not found for userId: " + id);
        }

        HotelUser hotel = hotelUser.orElse(null);
        hotel.setList(list);
        return hotel;
    }

    @Override
    public void deleteById(String id) {
        ratingFiegnService.deleteRating(id);  //
        userRepo.deleteById(id);  //
    }

      @Override
    public void updateUser(String id, HotelUser user) {
        Optional<HotelUser> getUser = userRepo.findById(id);

        if (getUser.isPresent()) {
            HotelUser hotelUser = getUser.get();

            if (user.getAboutMe() != null) {
                hotelUser.setAboutMe(user.getAboutMe());
            }
            if (user.getEmail() != null) {
                hotelUser.setEmail(user.getEmail());
            }

            if (user.getPassword() != null) {
                hotelUser.setPassword(user.getPassword());
            }

            userRepo.save(hotelUser);
        }
    }

    @Override
    public List<HotelUser> getByEmailOrderByUserId(String email) {

        List<HotelUser> list = userRepo.findByEmailOrderByUserIdAsc(email);
        return list.isEmpty() ? new ArrayList<>() : list;
    }

    @Override
    public List<HotelUser> getByAboutMe(String aboutMe) {

        List<HotelUser> list = userRepo.findByAboutMe(aboutMe);
        return list.isEmpty() ? new ArrayList<>() : list;
    }


    @Transactional
    @Override
    public List<ProjectNumberRoleDto> getNumbers() {

        ProjectNumberRole list = userRepo.countByRole();

        ProjectNumberRole list1 = userRepo.countByRoleAdmin();

        ProjectNumberRole list2 = userRepo.countByRoleGuset();
        List<ProjectNumberRole> finalList = new ArrayList<>();
        if (list != null) {
            finalList.add(list);
        }

        if (list1 != null) {

            finalList.add(list1);
        }

        if (list2 != null) {

            finalList.add(list2);

        }
        for (ProjectNumberRole li : finalList) {
            li.getCount();
            li.getCount();
        }

        List<ProjectNumberRoleDto> projectNumberRoleDto = new ArrayList<>();

        for (ProjectNumberRole li : finalList) {

            projectNumberRoleDto.add(new ProjectNumberRoleDto(li.getRoleName(), li.getCount()));
        }

        return projectNumberRoleDto;
    }

    @Override
    public void saveBulk(MultipartFile file) throws Exception {
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            CsvToBean<HotelUser> csvToBean = new CsvToBeanBuilder<HotelUser>(reader)
                    .withType(HotelUser.class)
                    .withSkipLines(1)
                    .build();
            List<HotelUser> users = csvToBean.parse();

            // Optionally upload image to Cloudinary for each user
            for (HotelUser user : users) {
                if (user.getImageId() != null) {
                    // Upload image to Cloudinary (assuming imageId is a URL or file name)
//                    Map<String, Object> uploadResult = cloudinary.uploader().upload(user.getImageId(), ObjectUtils.emptyMap());
//                    String imageUrl = (String) uploadResult.get("url");
                    // Save the image URL to the user entity
                    Long id=user.getImageId();
                    user.setImageId(id);
                }
            }

            // Save users to the database
            userRepo.saveAll(users);
        }
    }
}
