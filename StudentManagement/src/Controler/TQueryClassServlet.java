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

public class TQueryClassServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer classNumber=(Integer) req.getAttribute("classNumber");
		StudentService  stuService=new StudentServiceImpl();
		List<Student> stuList=stuService.selectStudentByClass(classNumber);
		req.setAttribute("studentList", stuList);
		req.setAttribute("classNumber", classNumber);
		req.getRequestDispatcher("/jsp/Tmain.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);	}
}
