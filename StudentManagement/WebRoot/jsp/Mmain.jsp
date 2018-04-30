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
#top_image{
	width:100%;
	height:300px;
	background-image: url("/StudentManagement/images/top-bg.png");
	background-position:center;
	background-repeat: no-repeat;
}
#student_top{
	clear: both;
	border:1px solid #5566AA;
	padding: 0px,10px,0px,10px;
	font-style: oblique;
	font-size: 20px;
	font: 000000;
}
#studentDataBg{
	padding:0px;
	border:1px solid #5566AA;
	clear: both;	
}
#add{
	margin-left:365px;
	font-size: 13px;	
}
#id{
	margin-left:410px;
}

</style>
</head>
<body>
		<div id="page">
			<div id=>
			<img alt="" src="/StudentManagement/images/topimage.png">
			</div>		
			
				
			<div id="student_top">
				<span id="id">身份：班长</span></br>
				测控17-${student.classNumber}班&nbsp&nbsp|&nbsp&nbsp学生信息查看

			</div>
			<div id="studentDataBg" >
				<table id="studentData" border="1px" bordercolor="99ccff">
					<tr>
						<th>姓名 </th>
						<th>学号</th>
						<th>密码</th>
						<th>性别</th>
						<th>生日</th>
						<th>家庭地址</th>
						<th>职务</th>
						<th>班级</th>
					</tr>
<c:forEach items="${studentList}" var="student">
					<tr>
<c:if test="${student.role!='老师'}">	
						<td>${student.name }</td>
						<td>${student.username }</td>
						<td>${student.password }</td>
						<td>
						<c:if test="${student.gender == 1}">男</c:if>
						<c:if test="${student.gender == 0}">女</c:if>
						</td>
						<td>${student.birthday }</td>
						<td>${student.address }</td>
						<td>${student.role }</td>
						<td>${student.classNumber}</td>
</c:if>											
					</tr>
</c:forEach>	
				</table>
			</div>

		</div>
</body>
</html>