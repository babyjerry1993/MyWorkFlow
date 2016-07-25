package sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserMapper;
import sy.model.User;
import sy.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
    
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectByUserId(Integer id) {
        // 通过主键获取user
        return userMapper.selectByUserId(id);
    }

	@Override
	public int deleteByPrimaryKey(Integer userid) {
		// 通过主键删除user
		return userMapper.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(User record) {
		// 插入数据
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// 可选插入
		return userMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// 可选更新数据
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// 更新数据
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<User> getUsers() {
		// 获取users
		return userMapper.getUsers();
	}

	@Override
	public User findUserByUsernameAndPassword(User user) {
		// 验证用户名和密码
		return userMapper.findUserByUsernameAndPassword(user);
	}

}