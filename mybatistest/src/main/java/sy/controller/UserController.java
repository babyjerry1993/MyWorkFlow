package sy.controller;

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


@Controller
@RequestMapping
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private TuserServiceI userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(Model model, String errMsg,HttpServletRequest request) {

		logger.info("进入---->login_GET");

		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();

		if (StringUtils.isNotEmpty((String)session.getAttribute("username"))) {
			// session判断用户是否已经登录
			logger.info("该账户已经登录");
			mv.setViewName("showUser");
			return mv;
		}
		if (StringUtils.isEmpty(errMsg)) {
			logger.info("errMsg内没有内容");
			model.addAttribute("errMsg", "");
		} else {
			model.addAttribute("errMsg", "fail");
		}
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView getLogin(Tuser user, HttpServletRequest request) {

		logger.info("进入---->login_POST");

		ModelAndView mv = new ModelAndView();

		Tuser res = userService.findUserByUsernameAndPassword(user);

		if (null != res) {
			
			String remark = userService.findTuserRemark(user);
			//设置session
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			
			if (remark.equals("employee")) {
				mv.setViewName("emp_main");
			} else if (remark.equals("boss")) {
				mv.setViewName("boss_main");
			}else if (remark.equals("manager")) {
				mv.setViewName("mana_main");
			}else {
				mv.setViewName("404");
			}
			
			logger.info("登录成功");
			return mv;
		}

		logger.info("登录失败");
		mv.addObject("errMsg", "fail");
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/showUser.do", method = RequestMethod.GET)
	public ModelAndView showUser(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("showUser");

		return mv;
	}

	@RequestMapping(value = "/empMain.do", method = RequestMethod.GET)
	public ModelAndView empMain() {

		ModelAndView mv = new ModelAndView();

		logger.info("进入了empMain方法");
		mv.setViewName("emp_main");

		return mv;
	}

	@RequestMapping(value = "/bossMain.do", method = RequestMethod.GET)
	public ModelAndView bossMain() {

		ModelAndView mv = new ModelAndView();

		logger.info("进入了bossMain方法");
		mv.setViewName("boss_main");

		return mv;
	}
	
	@RequestMapping(value = "/manaMain.do", method = RequestMethod.GET)
	public ModelAndView manaMain() {

		ModelAndView mv = new ModelAndView();

		logger.info("进入了manaMain方法");
		mv.setViewName("mana_main");

		return mv;
	}

	@RequestMapping(value = "/askForLeave.do", method = RequestMethod.GET)
	public ModelAndView askForLeave() {

		ModelAndView mv = new ModelAndView();
		
		logger.info("进入了askForLeave方法,这里要做运行一个[请假]流程");
		mv.setViewName("askForLeave");

		return mv;
	}
	
	@RequestMapping(value = "/doAsk.do", method = RequestMethod.GET)
	public ModelAndView doAsk() {

		ModelAndView mv = new ModelAndView();
		
		logger.info("进入了doAsk方法,发出申请");
		mv.setViewName("finishAsk");

		return mv;
	}

	@RequestMapping(value = "/checkAsk.do", method = RequestMethod.GET)
	public ModelAndView checkAsk() {

		ModelAndView mv = new ModelAndView();

		logger.info("进入了checkAsk方法,这里要做运行一个[审核]流程");
		mv.setViewName("checkAsk");

		return mv;
	}
	
	@RequestMapping(value = "/doCheck.do", method = RequestMethod.GET)
	public ModelAndView doCheck() {

		ModelAndView mv = new ModelAndView();

		logger.info("进入了doCheck方法,完成审核");
		mv.setViewName("finishCheck");

		return mv;
	}
	
	@RequestMapping(value = "/uploadWorkFlow.do", method = RequestMethod.GET)
	public ModelAndView uploadWorkFlow() {

		ModelAndView mv = new ModelAndView();
		
		logger.info("进入了uploadWorkFlow方法,这里要做的是上传业务流程");
		mv.setViewName("uploadWorkFlow");

		return mv;
	}
	
	@RequestMapping(value = "/doUpload.do", method = RequestMethod.GET)
	public ModelAndView doUpload() {

		ModelAndView mv = new ModelAndView();
		
		logger.info("进入了doUpload方法,上传工作完成");
		mv.setViewName("finishUpload");

		return mv;
	}
	

}