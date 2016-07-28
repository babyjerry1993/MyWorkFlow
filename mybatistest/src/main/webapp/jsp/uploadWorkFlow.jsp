<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>uploadWorkFlow</title>
</head>
<div align="left">
	<h1>manager:上传业务流程</h1>
	<hr />
	<form action="<%=request.getContextPath()%>/doUpload.do" method="post">
		<div class="" align="left">
			流程名称: <input id="filename" type="text" style="width: 200px;" value=""
				name="filename"><br> 流程文件: <input id="file" type="file"
				style="width: 200px;" value="" name="file"> <br> <input
				class="button_ok" type="submit" value="上传流程">
		</div>
	</form>
</div>
<body>
</body>
</html>
