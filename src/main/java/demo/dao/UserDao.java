package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;


public interface UserDao {

	@Select("SELECT u.user_id AS id,u.user_code AS password,u.user_name AS userName FROM epms_user u limit 0,20")
	List<User> selectUsers();
	
    
}
