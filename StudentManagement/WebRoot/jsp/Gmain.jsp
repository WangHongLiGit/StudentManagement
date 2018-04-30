<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息查看</title>
<style type="text/css">
body{	
	background-image: url("/StudentManagement/images/backgroundimage.jpg");
}
#teacher_top{
	border:1px solid #5566AA;
	padding: 0px,10px,0px,10px;
	font-style: oblique;
	font-size: 20px;
}
#teacherLeft{
	float: left;
	clear: both;

}
#teacherRight{
	margin-left: 300px;
}
</style>
</head>
<body>

<div id="teacherData" >
				<div id="teacher_top" >
					欢迎登陆：               ${student.name}
				</div>
				<div id="teacherLeft">
					<div>姓名: ${student.name}</div>
					<div>学号: ${student.username}</div>
					<div>密码: ${student.password}</div>
					<div>性别:			
						<c:if test="${student.gender == 1}">男</c:if>
						<c:if test="${student.gender == 0}">女</c:if>
					</div>
				</div>
				<div id="teacherRight">
					<div>生日: ${student.birthday}</div>
					<div>家庭地址: ${student.address}</div>
					<div>职务:${student.role}</div>
					<div>班级:${student.classNumber}</div>
				</div>
			</div>
</body>
</html>