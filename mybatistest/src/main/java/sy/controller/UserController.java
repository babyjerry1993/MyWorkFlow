package sy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sy.model.Tuser;
import sy.service.TuserServiceI;
import sy.util.SessionScope;

@Controller
@RequestMapping
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private TuserServiceI userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(Model model, String errMsg, @SessionScope("userName") String username) {

		logger.info("进入login_GET");

		ModelAndView mv = new ModelAndView();
		
		if (!StringUtils.isEmpty(username)) {
			// session判断用户是否已经登录
			logger.info("已经登录过的用户不必再登录,直接进入");
			mv.setViewName("showUser");
			return mv;
		}
		if (StringUtils.isEmpty(errMsg)) {
			model.addAttribute("errMsg", "");
		} else {
			model.addAttribute("errMsg", "fail");
		}
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView getLogin(Tuser user, HttpServletRequest request) {

		logger.info("进入login_POST");

		ModelAndView mv = new ModelAndView();

		System.out.println(user.getUsername());
		System.out.println(user.getUserpassword());

		Tuser res = userService.findUserByUsernameAndPassword(user);
		List<Tuser> list = new ArrayList<Tuser>();
		list = userService.getTusers();
		mv.addObject("users", list);
		System.out.println(list);
		

		if (null != res) {
			logger.info("登录成功");
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			mv.setViewName("showUser");
			return mv;
		}
		logger.info("登录失败");
//		System.out.println("我是sysout的打印");
		mv.addObject("errMsg", "fail");
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/showUser.do", method = RequestMethod.GET)
	public ModelAndView data(@SessionScope("username") String username) {

		ModelAndView mv = new ModelAndView();
		logger.info("用户名为:" + username);
		mv.setViewName("showUser");

		return mv;
	}

}