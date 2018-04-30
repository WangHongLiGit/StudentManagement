package Controler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modle.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

public class TUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8"); 
        resp.setContentType("text/html;charset=UTF-8");
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String gender=req.getParameter("gender");
        String birthday=req.getParameter("birthday");
        String address=req.getParameter("address");
        String role=req.getParameter("role");
        String classNumber=req.getParameter("classNumber");
        Integer id1=null;
        Integer gender1=null;
        Integer username1=null;
        Date birthday1=null;
        Integer classNumber1=null;
        if(gender!=null&&username!=null&&birthday!=null&&classNumber!=null&&id!=null){
        			id1=new Integer(id);
                	gender1=new Integer(gender);
                	username1=new Integer(username);
                	classNumber1=new Integer(classNumber);
                	try {
        				birthday1 = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
               }
        Student student=new Student();
        student.setId(id1);
        student.setName(name);
        student.setUsername(username1);
        student.setPassword(password);
        student.setGender(gender1);
        student.setAddress(address);
        student.setBirthday(birthday1);
        student.setClassNumber(classNumber1);
        student.setRole(role);
		StudentService studentservice=new StudentServiceImpl();
		studentservice.updateStudent(student);
		req.setAttribute("classNumber", classNumber1);
		req.getRequestDispatcher("/TQueryClassServlet").forward(req, resp);
	}
}
