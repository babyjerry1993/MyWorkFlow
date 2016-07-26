package sy.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sy.model.Tuser;
import sy.service.ManagerServiceI;
import sy.service.TuserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class TestMybatis {

	@Resource
	private TuserServiceI userService;

	@Resource
	private ManagerServiceI managerService;

	@Test
	public void select() {
		// getUserById
		Tuser user = userService.selectByTuserId(4);
		System.out.println(user.getUsername());
		System.out.println("中文中文");
	}

}
