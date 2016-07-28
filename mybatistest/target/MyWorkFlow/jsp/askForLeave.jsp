<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<style type="text/css">
.for {
	border:1px solid #AAA;
	margin: 100px auto;
	width: 40%;
	height: 80%;
	padding:20px;
}
</style>
</head>

<body>

	<div class="container">
		<form role="form" class="for" action="<%=request.getContextPath()%>/doAsk.do">
			<div>
				<br />
				<h1>填写请假单</h1>
				<hr />
			</div>
			<div class="form-group">
				<label for="name">天数</label> <input type="text" class="form-control"
					placeholder="输入要请假的天数">
			</div>
			<div class="form-group">
				<label for="name">事由</label>
				<textarea class="form-control" rows="3" placeholder="输入请假事由"></textarea>
			</div>
			<div class="form-group">
				<label for="name">备注</label>
				<textarea class="form-control" rows="3" placeholder="输入备注"></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">提交</button>
			</div>
		</form>
	</div>
</body>

</html>
