package Service;
import java.util.List;
import DAO.StudentDao;
import DAO.StudentDaoImpl;
import Modle.Student;
public class StudentServiceImpl implements StudentService {
	StudentDao studentdao= new StudentDaoImpl();

	public List<Student> selectStudentByClass(Integer classnumber) {
		return studentdao.selectStudentByClass(classnumber);
	}

	public void insertStudent(Student student) {
		studentdao.insertStudent(student);
	}

	public Student selectStudentById(Integer id) {
		return studentdao.selectStudentById(id);
	}

	public void updateStudent(Student student) {
		studentdao.updateStudent(student);
	}

	public void deleteById(Integer id) {
		studentdao.deleteById(id);
	}

	public Student selectStudentByNameAndPass(Integer username, String password) {
		return studentdao.selectStudentByNameAndPass(username, password);
	}
	

}
