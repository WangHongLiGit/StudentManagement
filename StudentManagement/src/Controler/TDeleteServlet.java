package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modle.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

public class TDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		String classNumber=req.getParameter("classNumber");
		Integer classNumber1=new Integer(classNumber);
		Integer id1=new Integer(id);
		StudentService  stuService=new StudentServiceImpl();
		stuService.deleteById(id1);
		req.setAttribute("classNumber", classNumber1);
		req.getRequestDispatcher("/TQueryClassServlet").forward(req, resp);	
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
