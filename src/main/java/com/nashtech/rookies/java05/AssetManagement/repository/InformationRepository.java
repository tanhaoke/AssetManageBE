package com.nashtech.rookies.java05.AssetManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nashtech.rookies.java05.AssetManagement.model.entity.Information;
import com.nashtech.rookies.java05.AssetManagement.model.enums.UserStatus;



@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
	@Query(value = "select i.location from information i where i.user_id ="
			+ " (select id from users where username = :userName)", nativeQuery = true)
    public String getLocationByUserName(String userName);   

    @Query(value = "select i.id, i.date_birth , i.first_name, i.gender, i.last_name, i.joined_date , i.user_id, i.location  from information i inner join users u  on u.id = i.user_id where i.location = :location and u.status != 'INACTIVE'", nativeQuery = true)
    public List<Information> findUserByLocationAndNotInactive(@Param("location") String location);

    @Query(value = "select  count(i.id) from information i  where i.location = :location", nativeQuery = true)
    public int findTotalUserSameLocation(@Param("location") String location);

    @Query(value = "select * from information i where i.location = :location limit 50 offset :offset ", nativeQuery = true)
    public List<Information> findAllUserSameLocation(@Param("location") String location, @Param("offset") int raw);

    @Query(value = "select * from information i where (i.first_name like %:content% or i.last_name like %:content%  or  i.user_id like %:content%) and i.location  = :location", nativeQuery = true)
    public List<Information> searchUser(@Param("content") String content, @Param("location") String location);

}
