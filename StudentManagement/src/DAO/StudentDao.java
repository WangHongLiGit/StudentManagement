package DAO;

import java.util.List;

import Modle.Student;
public interface StudentDao {
	public List<Student> selectStudentByClass(Integer classnumber);
	public void insertStudent(Student student);
	public Student selectStudentById(Integer id);
	public void updateStudent(Student student);
	public void deleteById(Integer id);
	public Student selectStudentByNameAndPass(Integer username ,String password);
}
