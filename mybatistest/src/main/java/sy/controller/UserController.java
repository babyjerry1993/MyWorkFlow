package sy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sy.model.User;
import sy.service.UserServiceI;
import sy.util.SessionScope;



@Controller
@RequestMapping
public class UserController {

	@Autowired
	private UserServiceI userService;
	
	@RequestMapping("/index")
	public ModelAndView index(Model model) {
		
		System.out.println("index...");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login.do",  method = RequestMethod.GET)
	public ModelAndView login(Model model,String errMsg,@SessionScope("userName") String username) {
		if(!StringUtils.isEmpty(username)){
			//session判断用户是否已经登录
			return new ModelAndView("showUser");
		}
		if(StringUtils.isEmpty(errMsg)){
			model.addAttribute("errMsg", "");
		}else{
			model.addAttribute("errMsg", "fail");
		}
		return new ModelAndView("showUser");
	}
	
	@RequestMapping(value = "/login.do",  method = RequestMethod.POST)
	public String getLogin(User user,HttpServletRequest request) {
		
		System.out.println(user.getUsername());
		System.out.println(user.getUserpassword());
		
		User res = userService.findUserByUsernameAndPassword(user);
		
		if(null!=res) {
			System.out.println("登录成功");
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			return "redirect:/showUser.jsp";
		}
		System.out.println("登录失败");
		return "redirect:/login.jsp?errMsg='fail'&Method='GET'";
	}
	
	@RequestMapping(value = "/showUser.do",  method = RequestMethod.GET)
	public String data(@SessionScope("username") String username) {
		
		System.out.println(username);
		return "showUser";
	}

}