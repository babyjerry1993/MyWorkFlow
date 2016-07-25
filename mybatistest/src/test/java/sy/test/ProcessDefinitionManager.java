package sy.test;

import java.io.InputStream;
import java.util.zip.ZipInputStream;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

//流程定义管理
public class ProcessDefinitionManager {
	// 获取流程引擎
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	// 部署流程定义，资源来自bpmn格式
	@Test
	public void deployProcessDefi() {
		Deployment deploy = processEngine.getRepositoryService()// 获取仓库服务
				.createDeployment()// 产生部署
				.name("采购流程")//
				.addClasspathResource("diagrams/leave.bpmn")// 添加资源bpmn
				.addClasspathResource("diagrams/leave.png")// 添加资源png
				.deploy();

		System.out.println("部署名称:" + deploy.getName());
		System.out.println("部署id:" + deploy.getId());
	}

	// 部署流程定义,资源来自zip格式
	@Test
	public void deployProcessDefiByZip() {
		InputStream in = getClass().getClassLoader().getResourceAsStream("BuyBill.zip");
		Deployment deploy = processEngine.getRepositoryService().createDeployment().name("采购流程")
				.addZipInputStream(new ZipInputStream(in)).deploy();

		System.out.println("部署名称:" + deploy.getName());
		System.out.println("部署id:" + deploy.getId());
	}

	// // 查看流程定义
	// @Test
	// public void queryProcessDefination() {
	// String processDefiKey = "myProcess";// 流程定义key
	// // 获取流程定义列表
	// List<ProcessDefinition> list =
	// processEngine.getRepositoryService().createProcessDefinitionQuery()
	// .processDefinitionKey(processDefiKey)// 流程定义key 由bpmn 的 process
	// .latestVersion()// 最新版本
	// .orderByProcessDefinitionVersion().desc()// 按版本的降序排序
	// .list();
	//
	// // 遍历结果
	// if (list != null && list.size() > 0) {
	// for (ProcessDefinition temp : list) {
	// System.out.print("流程定义的id: " + temp.getId());
	// System.out.print("流程定义的key: " + temp.getKey());
	// System.out.print("流程定义的版本: " + temp.getVersion());
	// System.out.print("流程定义部署的id: " + temp.getDeploymentId());
	// System.out.println("流程定义的名称: " + temp.getName());
	// }
	// }
	// }

	// // 查看bpmn 资源图片
	// @Test
	// public void viewImage() throws Exception {
	// String deploymentId = "1501";
	// String imageName = null;
	// // 取得某个部署的资源的名称 deploymentId
	// List<String> resourceNames =
	// processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);
	// // buybill.bpmn buybill.png
	// if (resourceNames != null && resourceNames.size() > 0) {
	// for (String temp : resourceNames) {
	// if (temp.indexOf(".png") > 0) {
	// imageName = temp;
	// }
	// }
	// }
	// /**
	// * 读取资源 deploymentId:部署的id resourceName：资源的文件名
	// */
	// InputStream resourceAsStream =
	// processEngine.getRepositoryService().getResourceAsStream(deploymentId,
	// imageName);
	//
	// // 把文件输入流写入到文件中
	// File file = new File("d:/" + imageName);
	// FileUtils.copyInputStreamToFile(resourceAsStream, file);
	//
	// }

	// 删除流程定义
	// @Test
	// public void deleteProcessDefi() {
	// // 通过部署id来删除流程定义
	// String deploymentId = "1501";
	// processEngine.getRepositoryService().deleteDeployment(deploymentId);
	// }

}
