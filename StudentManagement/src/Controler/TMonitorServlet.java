package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modle.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

public class TMonitorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		Integer id1=new Integer(id);
		String classNumber=req.getParameter("classNumber");
		Integer classNumber1=new Integer(classNumber);
		StudentService  stuService=new StudentServiceImpl();
		Student student=stuService.selectStudentById(id1);
		student.setRole("班长");
		stuService.updateStudent(student);
		req.setAttribute("classNumber", classNumber1);
		req.getRequestDispatcher("/TQueryClassServlet").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
