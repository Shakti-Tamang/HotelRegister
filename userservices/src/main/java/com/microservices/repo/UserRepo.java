package com.microservices.repo;

import com.microservices.entity.HotelUser;
import com.microservices.projection.ProjectNumberRole;
import com.microservices.projection.ProjectNumberRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<HotelUser,String> {
    public HotelUser  findByEmail(String email);

    public List<HotelUser> findByEmailOrderByUserIdAsc(String email);

    @Query(name = "HotelUser.findByAboutM")
    public List<HotelUser>findByAboutMe(@Param("aboutMe") String aboutMe);
//
//    package com.microservices.projection;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Data
//    public class ProjectNumberRoleDto {
//        private String roleName;
//
//        private Long count;
//    }

//    as above its must have same field


//    Do we need GROUP BY while getting roleName in aggregation?
//    Yes, when using an aggregate function like COUNT(), you must include GROUP BY if you are selecting a non-aggregated column like roleName.
//COUNT() – Counts the number of rows
//2️⃣ SUM() – Adds up values in a column
//3️⃣ AVG() – Calculates the average value
//4️⃣ MIN() – Returns the smallest value
//5️⃣ MAX() – Returns the largest value
//6️⃣ GROUP_CONCAT() – Concatenates values into a single string (MySQL)
//7️⃣ STRING_AGG() – Concatenates values (PostgreSQL, SQL Server)
    @Query("select u.role as roleName, COUNT(u) As count FROM HotelUser u where  u.role = 'ADMIN' group by u.role")
    public ProjectNumberRole countByRole();

    @Query("select u.role as roleName, COUNT(u) As count FROM HotelUser u where  u.role = 'USER' group by u.role")

    public ProjectNumberRole countByRoleAdmin();

    @Query("select u.role as roleName, COUNT(u) As count FROM HotelUser u where  u.role = 'GUEST' group by u.role")
     public ProjectNumberRole countByRoleGuset();

//    @Query("")
//    public HotelUser findByUsernameIsContaining();

}

