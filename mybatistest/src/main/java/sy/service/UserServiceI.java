package sy.service;

import java.util.List;

import sy.model.User;

public interface UserServiceI {    
    
    public User selectByUserId(Integer id);
    
    public int deleteByPrimaryKey(Integer userid);

    public int insert(User record);

    public int insertSelective(User record);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);

	public List<User> getUsers();

	public User findUserByUsernameAndPassword(User user);

}