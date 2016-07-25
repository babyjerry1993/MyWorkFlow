package sy.dao;


import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import sy.model.User;

@Repository(value = "userMapper")
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    @Select("select * from user where userId = #{userid}")
    User selectByUserId(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	@Select("SELECT userId,userName,userPassword,userEmail,userNickname,userBirthday,sex,userPoints,userRemark FROM user")
    List<User> getUsers();
	
	@Select("select * form user where userName = #{username} and userPassword = #{userpassword}")
	User findUserByUsernameAndPassword(User user);
  
}