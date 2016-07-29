package sy.service.impl;

import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.stereotype.Service;

import sy.form.WorkflowBean;
import sy.service.WorkflowServiceI;
@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowServiceI {

	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	private RepositoryService repositoryService = processEngine.getRepositoryService();
	private RuntimeService runtimeService = processEngine.getRuntimeService();
	private TaskService taskService = processEngine.getTaskService();
	private FormService formService = processEngine.getFormService();
	private HistoryService historyService = processEngine.getHistoryService();

	

	@Override
	public void saveNewDeploye(WorkflowBean workflowBean) {
		// 部署一个zip包含的工作流程定义
		try {
			// 将File类型的文件转化成ZipInputStream流
			ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(workflowBean.getFile()));
			repositoryService.createDeployment()// 创建部署对象
					.name(workflowBean.getFilename())// 添加部署名称
					.addZipInputStream(zipInputStream)//
					.deploy();// 完成部署
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
