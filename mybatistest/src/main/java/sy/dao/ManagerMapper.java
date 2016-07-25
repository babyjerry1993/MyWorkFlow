package sy.dao;

import org.springframework.stereotype.Repository;

import sy.model.Manager;

@Repository(value = "managerMapper")
public interface ManagerMapper {
	
    int deleteByPrimaryKey(Integer managerid);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer managerid);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}