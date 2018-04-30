<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理</title>
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

</style>
</head>
<body>
		<div id="page">
			<div id=>
			<img alt="" src="/StudentManagement/images/topimage.png">
			</div>
			

<c:forEach items="${studentList}" var="student">
	<c:if test="${student.role=='老师'}">
			<div id="teacherData" >
				<div id="teacher_top" >
					欢迎登陆： ${student.name}老师
				</div>
				<div id="teacherLeft">
					<div>姓名: ${student.name}</div>
					<div>性别:			
						<c:if test="${student.gender == 1}">男</c:if>
						<c:if test="${student.gender == 0}">女</c:if>
					</div>
					<div>生日: ${student.birthday}</div>
				</div>
				<div id="teacherRight">
					<div>家庭地址: ${student.address}</div>
					<div>职务:${student.role}</div>
					<div>班级:${student.classNumber}</div>
				</div>
			</div>
	</c:if>
</c:forEach>
			
			<div id="student_top">
				测控17-${student.classNumber}班&nbsp|&nbsp学生信息管理|&nbsp<span id="add" ><a href="/StudentManagement/tab/Ttoadd.jsp?classNumber=${student.classNumber}">
				<img src=""/ >添加学生</a></span>				
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
						<th>信息管理</th>
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
<c:if test="${student.role=='班长'}">	
						<td>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<a href="/StudentManagement/TQuerySingleServlet?id=${student.id}&classNumber=${student.classNumber}"><img src=""/><span >编辑</span></a>|
							<a href="/StudentManagement/TDeleteServlet?id=${student.id}&classNumber=${student.classNumber}"><img src=""/><span>删除</span></a>
						</td>
</c:if>					
<c:if test="${student.role=='普通学生'}">	
						<td>
							<a href="/StudentManagement/TMonitorServlet?id=${student.id}&classNumber=${student.classNumber}"><img src=""/><span id="edit">委任班长</span></a>|
							<a href="/StudentManagement/TQuerySingleServlet?id=${student.id}&classNumber=${student.classNumber}"><img src=""/><span>编辑</span></a>|
							<a href="/StudentManagement/TDeleteServlet?id=${student.id}&classNumber=${student.classNumber}"><img src=""/><span>删除</span></a>
						</td>
</c:if>
					</tr>
</c:forEach>	
				</table>
			</div>

		</div>
</body>
</html>