package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modle.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

public class GQueryClassServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id=(Integer) req.getAttribute("id");
		StudentService  stuService=new StudentServiceImpl();
		Student student=stuService.selectStudentById(id);
		Integer classNumber=student.getClassNumber();
		req.setAttribute("student", student);
		req.getRequestDispatcher("/jsp/Gmain.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);	}
}
