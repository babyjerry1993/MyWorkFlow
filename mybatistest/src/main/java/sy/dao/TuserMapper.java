package sy.dao;


import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import sy.model.Tuser;

@Repository(value = "userMapper")
public interface TuserMapper {
	
    int deleteByPrimaryKey(Integer userid);

    int insert(Tuser user);

    int insertSelective(Tuser user);

    @Select("select * from Tuser where userId = #{userid}")
    Tuser selectByTuserId(Integer userid);

    int updateByPrimaryKeySelective(Tuser user);

    int updateByPrimaryKey(Tuser user);
    
	@Select("SELECT userId,userName,userPassword,userEmail,userNickname,userBirthday,sex,userPoints,userRemark FROM Tuser")
    List<Tuser> getTusers();
	
	@Select("select * from Tuser where userName = #{username} and userPassword = #{userpassword}")
	Tuser findTuserByUsernameAndPassword(Tuser user);
	
	@Select("select userRemark from tuser where userName = #{username} and userPassword = #{userpassword}")
	String findTuserRemark(Tuser user);
	
//	@Select("select userRemark from tuser where userName = #{str}")
//	String findTuserRemarkBySession(String str);
  
}