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

import sy.model.Tuser;
import sy.service.TuserServiceI;
import sy.util.SessionScope;



@Controller
@RequestMapping
public class UserController {

	@Autowired
	private TuserServiceI userService;
	
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
	public ModelAndView getLogin(Tuser user,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(user.getUsername());
		System.out.println(user.getUserpassword());
		
		Tuser res = userService.findUserByUsernameAndPassword(user);
		
		if(null!=res) {
			System.out.println("登录成功");
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			mv.setViewName("showUser");
			return mv;
		}
		System.out.println("登录失败");
		mv.addObject("errMsg", "fail");
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/showUser.do",  method = RequestMethod.GET)
	public ModelAndView data(@SessionScope("username") String username) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println(username);
		mv.setViewName("showUser");
		
		return mv;
	}

}