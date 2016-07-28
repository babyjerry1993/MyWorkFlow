package sy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.TuserMapper;
import sy.model.Tuser;
import sy.service.TuserServiceI;

@Service("userService")
public class TuserServiceImpl implements TuserServiceI {
    
    private TuserMapper userMapper;

    public TuserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(TuserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Tuser selectByTuserId(Integer id) {
        // 通过主键获取user
        return userMapper.selectByTuserId(id);
    }

	@Override
	public int deleteByPrimaryKey(Integer userid) {
		// 通过主键删除user
		return userMapper.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(Tuser record) {
		// 插入数据
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(Tuser record) {
		// 可选插入
		return userMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Tuser record) {
		// 可选更新数据
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Tuser record) {
		// 更新数据
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Tuser> getTusers() {
		// 获取users
		return userMapper.getTusers();
	}

	@Override
	public Tuser findUserByUsernameAndPassword(Tuser user) {
		// 验证用户名和密码
		return userMapper.findTuserByUsernameAndPassword(user);
	}

	@Override
	public String findTuserRemark(Tuser user) {
		// 通过用户名获得用户的角色:管理员,老板,员工
		return userMapper.findTuserRemark(user);
	}

}