package sy.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class WorkFlowController {
	
	private static Logger logger = Logger.getLogger(WorkFlowController.class);
	
	@RequestMapping(value = "/doUpload.do", method = RequestMethod.GET)
	public ModelAndView doUpload() {

		ModelAndView mv = new ModelAndView();
		
		logger.info("进入了doUpload方法,上传工作完成");
		mv.setViewName("finishUpload");

		return mv;
	}
	
	@RequestMapping(value = "/doCheck.do", method = RequestMethod.GET)
	public ModelAndView doCheck() {

		ModelAndView mv = new ModelAndView();

		logger.info("进入了doCheck方法,完成审核");
		mv.setViewName("finishCheck");

		return mv;
	}
	
	@RequestMapping(value = "/doAsk.do", method = RequestMethod.GET)
	public ModelAndView doAsk() {

		ModelAndView mv = new ModelAndView();
		
		logger.info("进入了doAsk方法,发出申请");
		mv.setViewName("finishAsk");

		return mv;
	}
}
