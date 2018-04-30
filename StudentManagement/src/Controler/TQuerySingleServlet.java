package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modle.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

public class TQuerySingleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		Integer id1=new Integer(id);
		StudentService  stuService=new StudentServiceImpl();
		Student student=stuService.selectStudentById(id1);
		req.setAttribute("student", student);
		req.getRequestDispatcher("/tab/TtoUpdate.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
