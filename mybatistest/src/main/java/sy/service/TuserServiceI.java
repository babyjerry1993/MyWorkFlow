package sy.service;

import java.util.List;

import sy.model.Tuser;

public interface TuserServiceI { 
	
//	public String findTuserRemarkBySession(String str);
	
	public String findTuserRemark(Tuser record);
    
    public Tuser selectByTuserId(Integer id);
    
    public int deleteByPrimaryKey(Integer userid);

    public int insert(Tuser record);

    public int insertSelective(Tuser record);

    public int updateByPrimaryKeySelective(Tuser record);

    public int updateByPrimaryKey(Tuser record);

	public List<Tuser> getTusers();

	public Tuser findUserByUsernameAndPassword(Tuser user);

}