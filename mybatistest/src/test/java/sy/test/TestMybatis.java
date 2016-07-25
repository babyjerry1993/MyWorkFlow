package sy.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sy.model.User;
import sy.service.ManagerServiceI;
import sy.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class TestMybatis {

	@Resource
	private UserServiceI userService;

	@Resource
	private ManagerServiceI managerService;

	@Test
	public void select() {

		// getUserById
		User user = userService.selectByUserId(123);
		System.out.println(user.getUsername());

	}

}
