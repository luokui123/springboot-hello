package demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import demo.dao.User;
import demo.dao.UserDao;
import demo.dao.UserMapper;

@Service
public class  UserService {

	@Autowired
    JdbcTemplate jdbcTemplate;
	@Autowired
    UserDao userDao;
	@Autowired
	UserMapper userMapper;
	
	public List<User> query() {
		return this.queryUser();
	}
	
	
	public List<User> selectUsers() {
		return userDao.selectUsers();
	}
	
	public List<User> selectUsersMapper() {
		return userMapper.selectUsersMapper();
	}

    private List<User> queryUser() {
        String sql = "SELECT u.user_id,u.user_name,u.OPENID FROM t_user u";
        List<User> indexes = jdbcTemplate.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User index=new User();
				index.setId(rs.getLong("user_id"));
				index.setUserName(rs.getString("user_name"));
				index.setPassword(rs.getString("openid"));
				return index;
			}
			
		});
        return indexes;
    }
    
    
}
