package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modle.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8"); 
        resp.setContentType("text/html;charset=UTF-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		Integer username1=null;
		if(username!=null){
			username1=new Integer(username);
		}
		StudentService studentservice=new StudentServiceImpl();
		Student student=studentservice.selectStudentByNameAndPass(username1, password);
		if(student!=null){
			HttpSession session=req.getSession();
			session.setAttribute("student", student);
			resp.sendRedirect("/StudentManagement/jsp/Tmain.jsp");
		}else{
			resp.getWriter().print("用户名或者密码错误");
		}
		
		
	}

}
