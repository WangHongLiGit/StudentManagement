package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modle.Student;

public class LoginFIlter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("student");
		HttpServletResponse response=(HttpServletResponse)resp;
		if(student==null){
			response.sendRedirect("/StudentManagement/login.jsp");
		}else if(student!=null&&"老师".equals(student.getRole())){
			Integer classNumber=student.getClassNumber();
			request.setAttribute("classNumber", classNumber);
			request.getRequestDispatcher("/TQueryClassServlet").forward(request, response);
		}else if(student!=null&&"班长".equals(student.getRole())){
			Integer classNumber=student.getClassNumber();
			request.setAttribute("classNumber", classNumber);
			request.getRequestDispatcher("/MQueryClassServlet").forward(request, response);
		}else if(student!=null&&"普通学生".equals(student.getRole())){
			Integer id=student.getId();
			request.setAttribute("id", id);
			request.getRequestDispatcher("/GQueryClassServlet").forward(request, response);
		}	
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}


}
