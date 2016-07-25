package sy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.ManagerMapper;
import sy.model.Manager;
import sy.service.ManagerServiceI;

@Service("manageService")
public class ManageServiceImpl implements ManagerServiceI {

	private ManagerMapper managermapper;
	
	public ManagerMapper getManagermapper() {
		return managermapper;
	}

	@Autowired
	public void setManagermapper(ManagerMapper managermapper) {
		this.managermapper = managermapper;
	}

	@Override
	public Manager getManagerById(Integer id) {
		
		return managermapper.selectByPrimaryKey(id);
	}

}
