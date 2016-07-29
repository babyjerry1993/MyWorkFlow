package sy.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sy.form.WorkflowBean;
import sy.service.WorkflowServiceI;

@Controller
@RequestMapping
public class WorkFlowController {
	
	private static Logger logger = Logger.getLogger(WorkFlowController.class);
	
	@Autowired
	private WorkflowServiceI workflowService;
	
	@RequestMapping(value = "/doUpload.do", method = RequestMethod.POST)
	public ModelAndView doUpload(WorkflowBean workflowBean) {

		ModelAndView mv = new ModelAndView();
		
		workflowService.saveNewDeploye(workflowBean);
		
		logger.info("进入了doUpload方法,上传并部署业务流程完成");
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
