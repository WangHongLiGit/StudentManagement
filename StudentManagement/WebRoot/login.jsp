<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title><style type="text/css">
body{
	background-color: #ccffcc;
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
#login{
	border: 1px solid ;
	background-image: url("/StudentManagement/images/backgroundimage.jpg");
	margin: 30%;
	padding: 10px;
}
input{
	background-color: #55AAAA;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="login">
		<form action="/StudentManagement/LoginServlet" method="post">
			<span class="STYLE1">用户名</span><input name="username" type="text"></br>
 			<span class="STYLE1">密码 &nbsp&nbsp&nbsp</span><input name="password" type="password">
 			&nbsp&nbsp<input type="submit" value="登陆">
 		</form>
	</div>
</body>
</html>