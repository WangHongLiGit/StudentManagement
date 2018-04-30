<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% 
	String classNumber=request.getParameter("classNumber");
	request.setAttribute("classNumber",classNumber);
%>
<body>
	<form action="/StudentManagement/TAddServlet" method="post">
		姓名<input type="text" name="name"></br>
		学号<input type="text" name="username"></br>
		密码<input type="password" name="password"></br>
		性别<input type="radio" name="gender" value="1"checked="checked">男
			<input type="radio" name="gender" value="0">女</br>
				生日<input type="text" name="birthday"></br>
				住址<input type="text" name="address"></br>
				职务<select name="role">
					<option value="班长">班长</option>
					<option value="普通学生">普通学生</option>
				</select>
				
		<input type="hidden" name="classNumber"  value="${classNumber}"></br>
		<input type="submit" value="添加">
	</form>

</body>
</html>